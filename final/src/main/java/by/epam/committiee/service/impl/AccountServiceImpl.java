package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.HasherException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.mail.MailSender;
import by.epam.committiee.pool.ConnectionPool;
import by.epam.committiee.security.AccountValidator;
import by.epam.committiee.security.Hasher;
import by.epam.committiee.security.SaltGenerator;
import by.epam.committiee.service.AccountService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private AccountDao accountDao = AccountDao.getInstance();
    private AccountValidator validator = new AccountValidator();

    @Override
    public Account signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("invalid login");
        }
        if (password == null || password.isEmpty()){
            throw new ServiceException("invalid password");
        }
        try{

            if (validator.validate(login)){
                return accountDao.findBy(login,password);
            }else {
                throw new ServiceException();
            }
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Account signUp(String login, String password, String email) throws ServiceException {
        Account newAccount = new Account();
        if(validator.validate(login)){
            logger.debug("Account with this login is currently exists");
            throw new ServiceException();
        }
        try {
            newAccount.setLogin(login);
            byte[] salt = new SaltGenerator().generate();
            byte[] hash = new Hasher().hash(newAccount.getPassword(), salt);
            newAccount.setSalt(salt);
            newAccount.setHash(hash);
            newAccount.setPassword(password);
            newAccount.setRole(Role.USER);
            newAccount.setEmail(email);
            MailSender mailSender = new MailSender("dorhead@mail.ru", "Registration", "You successfully registered");
            mailSender.send();
            AccountDao.getInstance().save(newAccount);
        } catch (DaoException | HasherException e) {
            throw new ServiceException(e);
        }
        return newAccount;
    }

    @Override
    public List<Account> findAll() throws ServiceException {
        try{
            return accountDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Account findById(Long id) throws ServiceException {
        try{
            return accountDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(Account obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            accountDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Account obj) throws ServiceException {
        try{
            accountDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            accountDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }
}