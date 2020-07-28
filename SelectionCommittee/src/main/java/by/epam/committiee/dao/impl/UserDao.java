package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.User;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
//    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_USERS = "select id, surname, name, patronymic,passport_number from user";
    private static final String INSERT_USER = "insert into user(id, surname, name, patronymic,passport_number) values (?,?,?,?,?)";
    private static final String DELETE_USER = "delete from user where id = ? ";
    private static final String UPDATE_USER = "UPDATE user SET surname = ?,name = ?,patronymic = ?,passport_number = ? WHERE id = ?";
    private static final String GET_USER = "select id, surname, name, patronymic,passport_number from user WHERE id = ?";
    private static final String GET_USER_BY_PASSPORT_NUMBER = "select id, surname, name, patronymic,passport_number from user WHERE passport_number = ?";

    private static final String ID_COLUMN = "id";
    private static final String SURNAME_COLUMN = "surname";
    private static final String NAME_COLUMN = "name";
    private static final String PATRONYMIC_COLUMN = "patronymic";
    private static final String PASSPORT_NUM_COLUMN = "passport_number";

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

//                File file=new File("/resources/database.properties/images ".concat(String.valueOf(user.getId())).concat(".jpg"));
//                FileOutputStream fileOutputStream=new FileOutputStream(file);
//                Blob blob=resultSet.getBlob(IMAGE_COLUMN);
//                byte[] bytes = blob.getBytes(1, (int)blob.length());
//                fileOutputStream.write(bytes);
//                user.setImage(file);
                users.add(user);
            }
        } catch (SQLException e) {
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

//        File file= user.getImage();
//            if (file != null) {
//                FileInputStream fileInputStream = new FileInputStream(file);
//
//                preparedStatement.setBinaryStream(6, fileInputStream, (int) file.length());
//            } else{
//                file = new File("F:\\EpamGitRep\\SelectionCommittee\\src\\main\\resources\\t4.png");
//                preparedStatement.setBinaryStream(6,new FileInputStream(file), (int) file.length());
//
//            }
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
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
        preparedStatement.setLong(5, user.getId());

//        File file= user.getImage();
//        FileInputStream fileInputStream=new FileInputStream(file);
//        preparedStatement.setBinaryStream(6,fileInputStream,(int)file.length());

        preparedStatement.executeUpdate();
        }catch (SQLException e) {
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

//                File file=new File("/resources/database.properties/images ".concat(String.valueOf(user.getId())).concat(".jpg"));
//                FileOutputStream fileOutputStream=new FileOutputStream(file);
//                Blob blob=resultSet.getBlob(IMAGE_COLUMN);
//                byte[] bytes=blob.getBytes(1, (int)blob.length());
//                fileOutputStream.write(bytes);
//                user.setImage(file);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
        //            logger.error("Can't close result set: ", e);
                }
            }
        }
        return user;
    }


    public User find(String passportNumber) throws DaoException {
        User user = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_USER_BY_PASSPORT_NUMBER)){
            preparedStatement.setString(1, passportNumber);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(ID_COLUMN));
                user.setSurname(resultSet.getString(SURNAME_COLUMN));
                user.setName(resultSet.getString(NAME_COLUMN));
                user.setPatronymic(resultSet.getString(PATRONYMIC_COLUMN));
                user.setPassportNumber(resultSet.getString(PASSPORT_NUM_COLUMN));

//                File file=new File("/resources/database.properties/images ".concat(String.valueOf(user.getId())).concat(".jpg"));
//                FileOutputStream fileOutputStream=new FileOutputStream(file);
//                Blob blob=resultSet.getBlob(IMAGE_COLUMN);
//                byte[] bytes=blob.getBytes(1, (int)blob.length());
//                fileOutputStream.write(bytes);
//                user.setImage(file);
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    //logger.error("Can't close result set: ", e);
                }
            }
        }
        return user;
    }
}
