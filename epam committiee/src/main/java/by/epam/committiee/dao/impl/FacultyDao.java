package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.Address;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDao implements Dao<Faculty> {
   // private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_FACULTIES = "select id,name,exam_one,exam_two,exam_three from faculty";
    private static final String INSERT_FACULTY = "insert into faculty(id,name,exam_one,exam_two,exam_three) values (?,?,?,?,?)";
    private static final String DELETE_FACULTY = "delete from faculty where id = ? ";
    private static final String UPDATE_FACULTY = "UPDATE faculty SET name = ?,exam_one = ?,exam_two = ?,  exam_three = ? WHERE id = ?";
    private static final String GET_FACULTY = "select id,name,exam_one,exam_two,exam_three from faculty WHERE id = ?";


    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String EXAM_ONE_COLUMN = "exam_one";
    private static final String EXAM_TWO_COLUMN = "exam_two";
    private static final String EXAM_THREE_COLUMN = "exam_three";

    private static final FacultyDao instance = new FacultyDao();

    private FacultyDao(){}

    public static FacultyDao getInstance() {
        return instance;
    }

    @Override
    public List<Faculty> findAll() throws DaoException {
        List<Faculty> faculties = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_FACULTIES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                faculties.add(new Faculty(resultSet.getInt(ID_COLUMN),resultSet.getString(NAME_COLUMN),resultSet.getString(EXAM_ONE_COLUMN),
                        resultSet.getString(EXAM_TWO_COLUMN), resultSet.getString(EXAM_THREE_COLUMN)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return faculties;
    }

    @Override
    public void save(Faculty faculty) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_FACULTY)) {
            preparedStatement.setLong(1, faculty.getId());
            preparedStatement.setString(2, faculty.getName());
            preparedStatement.setString(3, faculty.getExamOne());
            preparedStatement.setString(4, faculty.getExamTwo());
            preparedStatement.setString(5,faculty.getExamThree());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_FACULTY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Faculty faculty) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_FACULTY)) {
            preparedStatement.setString(1, faculty.getName());
            preparedStatement.setString(2, faculty.getExamOne());
            preparedStatement.setString(3, faculty.getExamTwo());
            preparedStatement.setString(4,faculty.getExamThree());
            preparedStatement.setLong(5, faculty.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Faculty find(long id) throws DaoException {
        Faculty faculty = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_FACULTY);
        ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                faculty = new Faculty(resultSet.getInt(ID_COLUMN),resultSet.getString(NAME_COLUMN),resultSet.getString(EXAM_ONE_COLUMN),
                        resultSet.getString(EXAM_TWO_COLUMN), resultSet.getString(EXAM_THREE_COLUMN));
            }
        }catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                  //  logger.error("Can't close result set: ", e);
                }
            }
        }
        return faculty;
    }
}
