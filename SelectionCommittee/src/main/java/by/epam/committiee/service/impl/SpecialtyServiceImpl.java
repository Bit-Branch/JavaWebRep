package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AccountDao;
import by.epam.committiee.dao.impl.SpecialityDao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Specialty;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.SpecialtyService;

import java.util.List;

public class SpecialtyServiceImpl implements SpecialtyService {
    private SpecialityDao specialityDao = SpecialityDao.getInstance();

    @Override
    public List<Specialty> findUserSpecialties(long userId) throws ServiceException {
        try{
            return specialityDao.findAllByUserId(userId);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public List<Specialty> findFacultySpecialties(long facultyId) throws ServiceException {
        try{
            return specialityDao.findAllByFacultyId(facultyId);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public List<Specialty> findAll() throws ServiceException {
        try{
            return specialityDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Specialty findById(Long id) throws ServiceException {
        try{
            return specialityDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(Specialty obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            specialityDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Specialty obj) throws ServiceException {
        try{
            specialityDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            specialityDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }
}
