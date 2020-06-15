package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = AccountDao.getInstance();

    @Override
    public Account signIn(String login, String password) throws ServiceException {
        if (login == null || login.isEmpty()){
            throw new ServiceException("invalid login");
        }
        if (password == null || password.isEmpty()){
            throw new ServiceException("invalid password");
        }
        try{
            return accountDao.findBy(login,password);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }


    @Override
    public void register(Account account) throws ServiceException {
            create(account);
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