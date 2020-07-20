package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.Faculty;
import by.epam.committiee.entity.Result;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResultDao implements Dao<Result> {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_RESULTS = "select id,certificate_mark,exam_one_mark,exam_two_mark,exam_three_mark,credited from result";
    private static final String INSERT_RESULT = "insert into result(id,certificate_mark,exam_one_mark,exam_two_mark,exam_three_mark,credited) values (?,?,?,?,?,?)";
    private static final String DELETE_RESULT = "delete from result where id = ? ";
    private static final String UPDATE_RESULT = "UPDATE result SET certificate_mark = ?,exam_one_mark = ?,exam_two_mark = ?,  exam_three_mark = ?, credited = ? WHERE id = ?";
    private static final String GET_RESULT = "select id,certificate_mark,exam_one_mark,exam_two_mark,exam_three_mark,credited from result WHERE id = ?";


    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String EXAM_ONE_COLUMN = "exam_one_mark";
    private static final String EXAM_TWO_COLUMN = "exam_two_mark";
    private static final String EXAM_THREE_COLUMN = "exam_two_mark";
    private static final String CREDITED_COLUMN = "credited";

    private static final ResultDao instance = new ResultDao();

    private ResultDao(){}

    public static ResultDao getInstance() {
        return instance;
    }

    @Override
    public List<Result> findAll() throws DaoException {
        List<Result> results = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_RESULTS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                results.add(new Result(resultSet.getLong(ID_COLUMN),resultSet.getInt(NAME_COLUMN),resultSet.getInt(EXAM_ONE_COLUMN),
                        resultSet.getInt(EXAM_TWO_COLUMN), resultSet.getInt(EXAM_THREE_COLUMN),resultSet.getBoolean(CREDITED_COLUMN)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return results;
    }

    @Override
    public void save(Result result) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_RESULT)) {
            preparedStatement.setLong(1, result.getId());
            preparedStatement.setInt(2, result.getCertificateMark());
            preparedStatement.setInt(3, result.getFirstExamMark());
            preparedStatement.setInt(4, result.getSecondExamMark());
            preparedStatement.setInt(5,result.getThirdExamMark());
            preparedStatement.setBoolean(6,result.isCredited());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_RESULT)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Result result) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_RESULT)) {
            preparedStatement.setInt(1, result.getCertificateMark());
            preparedStatement.setInt(2, result.getFirstExamMark());
            preparedStatement.setInt(3, result.getSecondExamMark());
            preparedStatement.setInt(4,result.getThirdExamMark());
            preparedStatement.setBoolean(5,result.isCredited());
            preparedStatement.setLong(6, result.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Result find(long id) throws DaoException {
        Result result = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_RESULT);
        ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = new Result(resultSet.getLong(ID_COLUMN),resultSet.getInt(NAME_COLUMN),resultSet.getInt(EXAM_ONE_COLUMN),
                        resultSet.getInt(EXAM_TWO_COLUMN), resultSet.getInt(EXAM_THREE_COLUMN),resultSet.getBoolean(CREDITED_COLUMN));
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
        return result;
    }
}
