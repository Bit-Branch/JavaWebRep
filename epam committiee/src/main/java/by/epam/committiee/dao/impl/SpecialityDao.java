package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.entity.Specialty;
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

public class SpecialityDao implements Dao<Specialty> {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_SPECIALTIES = "select id,plan,faculty_id from specialty";
    private static final String INSERT_SPECIALTY = "insert into specialty(id,plan,faculty_id) values (?,?,?)";
    private static final String DELETE_SPECIALTY = "delete from specialty where id = ? ";
    private static final String UPDATE_SPECIALTY = "UPDATE specialty SET plan = ?,faculty_id = ? WHERE id = ?";
    private static final String GET_SPECIALTY = "select id,plan,faculty_id from specialty WHERE id = ?";


    private static final String ID_COLUMN = "id";
    private static final String PLAN_COLUMN = "plan";
    private static final String FACULTY_ID_COLUMN = "faculty_id";

    private static final SpecialityDao instance = new SpecialityDao();

    private SpecialityDao(){}

    public static SpecialityDao getInstance() {
        return instance;
    }

    @Override
    public List<Specialty> findAll() throws DaoException {
        List<Specialty> specialties = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_SPECIALTIES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                specialties.add(new Specialty(resultSet.getInt(ID_COLUMN),resultSet.getInt(PLAN_COLUMN),
                        resultSet.getInt(FACULTY_ID_COLUMN)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return specialties;
    }

    @Override
    public void save(Specialty specialty) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SPECIALTY)) {
            preparedStatement.setLong(1, specialty.getId());
            preparedStatement.setInt(2, specialty.getPlan());
            preparedStatement.setLong(3, specialty.getFacultyId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_SPECIALTY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Specialty specialty) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_SPECIALTY)) {
            preparedStatement.setInt(1, specialty.getPlan());
            preparedStatement.setLong(2, specialty.getFacultyId());
            preparedStatement.setLong(3, specialty.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Specialty find(long id) throws DaoException {
        Specialty specialty = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_SPECIALTY);
        ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialty = new Specialty(resultSet.getInt(ID_COLUMN),resultSet.getInt(PLAN_COLUMN),
                        resultSet.getInt(FACULTY_ID_COLUMN));
            }
        }catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Can't close result set: ", e);
                }
            }
        }
        return specialty;
    }
}
