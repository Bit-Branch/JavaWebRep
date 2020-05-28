package services;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    void save(T t) throws SQLException, ClassNotFoundException;

    void update(T t) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException, ClassNotFoundException;

    T get(int id);
}
