package by.epam.committiee.service;



import by.epam.committiee.exception.ServiceException;

import java.util.List;

public interface Service<T> {
    List<T> findAll() throws ServiceException;
    T findById(Long id) throws ServiceException;
    void create(T obj) throws ServiceException;
    void update(T obj) throws ServiceException;
    void delete(Long id) throws ServiceException;
}