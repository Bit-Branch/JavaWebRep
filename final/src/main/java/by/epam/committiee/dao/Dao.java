package by.epam.committiee.dao;

import by.epam.committiee.exception.DaoException;

import java.util.List;

public interface Dao<T> {

    List<T> findAll() throws DaoException;

    void save(T t) throws DaoException;

    void update(T t) throws DaoException;

    void delete(long id) throws DaoException;

    T find(long id) throws DaoException;

}
