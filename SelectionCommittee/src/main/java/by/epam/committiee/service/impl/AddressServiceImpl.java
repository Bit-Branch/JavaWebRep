package by.epam.committiee.service.impl;

import by.epam.committiee.dao.impl.AddressDao;
import by.epam.committiee.entity.Address;
import by.epam.committiee.entity.User;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.exception.ServiceException;
import by.epam.committiee.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    //  private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    private AddressDao addressDao = AddressDao.getInstance();

    @Override
    public Address findByUserId(Long id) throws ServiceException {
        try{
            return addressDao.findByUserId(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public List<Address> findAll() throws ServiceException {
        try{
            return addressDao.findAll();
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public Address findById(Long id) throws ServiceException {
        try{
            return addressDao.find(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void create(Address obj) throws ServiceException {
        try{
            Integer id = findAll().size();
            obj.setId(id);
            addressDao.save(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void update(Address obj) throws ServiceException {
        try{
            addressDao.update(obj);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try{
            addressDao.delete(id);
        }catch (DaoException ex){
            throw new ServiceException();
        }
    }


}
