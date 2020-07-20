package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.dao.impl.UserDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.entity.User;
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
import java.util.UUID;

public class AccountServiceImpl implements AccountService {
  //  private static Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    private AccountDao accountDao = AccountDao.getInstance();
    private AccountValidator validator = new AccountValidator();

    @Override
    public boolean signIn(String login, String password) {
        if (validator.validate(login,password)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean signUp(String surname, String name, String patronymic, String passportNumber, String login, String password, String email) throws ServiceException {
        Account newAccount = new Account();
        if(validator.validate(login,password)){
      //      logger.debug("Account with this login is currently exists");
            return false;
        }
        try {
            newAccount.setLogin(login);
            newAccount.setPassword(password);
            byte[] salt = new SaltGenerator().generate();
            byte[] hash = new Hasher().hash(newAccount.getPassword(), salt);
            newAccount.setSalt(salt);
            newAccount.setHash(hash);

            newAccount.setRole(Role.USER);
            newAccount.setEmail(email);
       //     MailSender mailSender = new MailSender("dorhead@mail.ru", "Registration", "You successfully registered");
        //    mailSender.send();

            User user = new User();
            user.setSurname(surname);
            user.setName(name);
            user.setPatronymic(patronymic);
            user.setPassportNumber(passportNumber);
            user.setSpecialtyId(1);
       //     long id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
       //     user.setId(id);
            UserDao.getInstance().save(user);

       //     newAccount.setId(id);
            newAccount.setId(UserDao.getInstance().find(passportNumber).getId());
            AccountDao.getInstance().save(newAccount);


        } catch (DaoException | HasherException e) {
    //        logger.error(e);
            throw new ServiceException(e);
        }
        return true;
    }

    @Override
    public Role receiveRole(String login, String password) throws ServiceException{
        Role role;
        try {
            role = accountDao.findBy(login, password).getRole();
        } catch (DaoException e) {
     //       logger.error(e);
            throw new ServiceException(e);
        }
        return role;
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