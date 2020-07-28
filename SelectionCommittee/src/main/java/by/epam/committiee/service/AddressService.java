package by.epam.committiee.service;

import by.epam.committiee.entity.Address;
import by.epam.committiee.exception.ServiceException;

public interface AddressService extends Service<Address> {
    Address findByUserId(Long id) throws ServiceException;
}
