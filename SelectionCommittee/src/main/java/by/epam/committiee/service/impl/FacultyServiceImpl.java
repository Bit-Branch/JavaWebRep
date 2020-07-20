package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.dao.impl.FacultyDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.pool.ConnectionPool;
import by.epam.committiee.service.FacultyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class FacultyServiceImpl implements FacultyService {
   // private static Logger logger = LogManager.getLogger(FacultyServiceImpl.class);

    private FacultyDao facultyDao = FacultyDao.getInstance();

    @Override
    public List<Faculty> findAll() throws ServiceException {
        try{
            return facultyDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Faculty findById(Long id) throws ServiceException {
        try{
            return facultyDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(Faculty obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            facultyDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Faculty obj) throws ServiceException {
        try{
            facultyDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            facultyDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }
}
