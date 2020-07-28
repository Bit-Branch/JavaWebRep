package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.dao.impl.UserDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.User;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    //  private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private UserDao userDao = UserDao.getInstance();


    @Override
    public List<User> findAll() throws ServiceException {
        try{
            return userDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public User findById(Long id) throws ServiceException {
        try{
            return userDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(User obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            userDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(User obj) throws ServiceException {
        try{
            userDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            userDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }
}
