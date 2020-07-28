package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.FacultyDao;
import by.epam.committiee.dao.impl.ResultDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Result;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.ResultService;

import java.util.List;

public class ResultServiceImpl implements ResultService {
    private ResultDao resultDao = ResultDao.getInstance();
    @Override
    public List<Result> findAll() throws ServiceException {
        try{
            return resultDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Result findById(Long id) throws ServiceException {
        try{
            return resultDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(Result obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            resultDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Result obj) throws ServiceException {
        try{
            resultDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            resultDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }
}
