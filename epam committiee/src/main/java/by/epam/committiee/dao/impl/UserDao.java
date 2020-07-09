package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.User;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_USERS = "select id, surname, name, patronymic,passport_number,specialty_id,image from user";
    private static final String INSERT_USER = "insert into user(id, surname, name, patronymic,passport_number,specialty_id,image) values (?,?,?,?,?,?,?)";
    private static final String DELETE_USER = "delete from user where id = ? ";
    private static final String UPDATE_USER = "UPDATE user SET surname = ?,name = ?,patronymic = ?,passport_number = ?, specialty_id = ?, image = ? WHERE id = ?";
    private static final String GET_USER = "select id, surname, name, patronymic,passport_number,specialty_id,image from user WHERE id = ?";

    private static final String ID_COLUMN = "id";
    private static final String SURNAME_COLUMN = "surname";
    private static final String NAME_COLUMN = "name";
    private static final String PATRONYMIC_COLUMN = "patronymic";
    private static final String PASSPORT_NUM_COLUMN = "passport_number";
    private static final String SPECIALTY_ID_COLUMN = "specialty_id";
    private static final String IMAGE_COLUMN = "image";

    private static final UserDao instance = new UserDao();

    private UserDao(){}

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USERS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(ID_COLUMN));
                user.setSurname(resultSet.getString(SURNAME_COLUMN));
                user.setName(resultSet.getString(NAME_COLUMN));
                user.setPatronymic(resultSet.getString(PATRONYMIC_COLUMN));
                user.setPassportNumber(resultSet.getString(PASSPORT_NUM_COLUMN));
                user.setSpecialtyId(resultSet.getLong(SPECIALTY_ID_COLUMN));

                File file=new File("/resources/database.properties/images ".concat(String.valueOf(user.getId())).concat(".jpg"));
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                Blob blob=resultSet.getBlob(IMAGE_COLUMN);
                byte[] bytes = blob.getBytes(1, (int)blob.length());
                fileOutputStream.write(bytes);
                user.setImage(file);
                users.add(user);
            }
        } catch (SQLException | IOException e) {
            throw new DaoException(e);
        }
        return users;
    }

    @Override
    public void save(User user) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USER)){
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(4, user.getPatronymic());
        preparedStatement.setString(5, user.getPassportNumber());
        preparedStatement.setLong(6, user.getSpecialtyId());

        File file= user.getImage();
        FileInputStream fileInputStream=new FileInputStream(file);

        preparedStatement.setBinaryStream(7,fileInputStream,(int)file.length());
        preparedStatement.executeUpdate();
    } catch (SQLException | FileNotFoundException e) {
        throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_USER)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_USER)) {
        preparedStatement.setString(1, user.getSurname());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPatronymic());
        preparedStatement.setString(4, user.getPassportNumber());
        preparedStatement.setLong(5, user.getSpecialtyId());
        preparedStatement.setLong(6, user.getId());

        File file= user.getImage();
        FileInputStream fileInputStream=new FileInputStream(file);
        preparedStatement.setBinaryStream(7,fileInputStream,(int)file.length());

        preparedStatement.executeUpdate();
        }catch (SQLException | FileNotFoundException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User find(long id) throws DaoException {
        User user = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_USER)){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(ID_COLUMN));
                user.setSurname(resultSet.getString(SURNAME_COLUMN));
                user.setName(resultSet.getString(NAME_COLUMN));
                user.setPatronymic(resultSet.getString(PATRONYMIC_COLUMN));
                user.setPassportNumber(resultSet.getString(PASSPORT_NUM_COLUMN));
                user.setSpecialtyId(resultSet.getLong(SPECIALTY_ID_COLUMN));

                File file=new File("/resources/database.properties/images ".concat(String.valueOf(user.getId())).concat(".jpg"));
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                Blob blob=resultSet.getBlob(IMAGE_COLUMN);
                byte[] bytes=blob.getBytes(1, (int)blob.length());
                fileOutputStream.write(bytes);
                user.setImage(file);
            }
            resultSet.close();
        } catch (FileNotFoundException e) {
            logger.error("Can't find file: ",e);
        } catch (SQLException | IOException e) {
            throw new DaoException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error("Can't close result set: ", e);
                }
            }
        }
        return user;
    }
}
