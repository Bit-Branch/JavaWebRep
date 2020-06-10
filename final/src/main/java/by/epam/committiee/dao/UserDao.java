package by.epam.committiee.dao;

import by.epam.committiee.entity.User;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    private static final String SELECT_ALL_USERS = "select * from user";
    private static final String INSERT_USER = "insert into user(id, surname, name, patronymic,passport_number,certificate_grade,medal,specialty_id,image) values (?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_USER = "delete from user where id = ? ";
    private static final String UPDATE_USER = "UPDATE user SET surname = ?,name = ?,patronymic = ?,passport_number = ?,certificate_grade = ?,medal = ?, specialty_id = ?, image = ? WHERE id = ?";
    private static final String GET_USER = "select * from user WHERE id = ?";

    private static final String ID_COL = "id";
    private static final String SURNAME_COL = "surname";
    private static final String NAME_COL = "name";
    private static final String PATRONYMIC_COL = "patronymic";
    private static final String PASSPORT_NUM_COL = "passport_number";
    private static final String CERTIFICATE_COL = "certificate_grade";
    private static final String MEDAL_COL = "medal";
    private static final String SPECIALTY_ID_COL = "specialty_id";
    private static final String IMAGE_COL = "image";

    private static final UserDao instance = new UserDao();

    private UserDao(){}

    public static UserDao getInstance() {
        return instance;
    }

    @Override
    public List<User> getAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(ID_COL));
                user.setSurname(resultSet.getString(SURNAME_COL));
                user.setName(resultSet.getString(NAME_COL));
                user.setPatronymic(resultSet.getString(PATRONYMIC_COL));
                user.setPassportNumber(resultSet.getString(PASSPORT_NUM_COL));
                user.setCertificateGrade(resultSet.getInt(CERTIFICATE_COL));
                user.setHasMedal(resultSet.getBoolean(MEDAL_COL));
                user.setSpecialtyId(resultSet.getLong(SPECIALTY_ID_COL));

                File f=new File("src/main/resources/database/images " + user.getId() + ".jpg");
                FileOutputStream fs=new FileOutputStream(f);
                Blob blob=resultSet.getBlob(IMAGE_COL);
                byte[] b=blob.getBytes(1, (int)blob.length());
                fs.write(b);

                user.setImage(f);
                users.add(user);
            }
            resultSet.close();
        } catch (SQLException | IOException e) {
            throw new DaoException(e.getMessage());
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
        preparedStatement.setInt(6, user.getCertificateGrade());
        preparedStatement.setBoolean(7, user.isHasMedal());
        preparedStatement.setLong(8, user.getSpecialtyId());

        File f= user.getImage();
        FileInputStream fs=new FileInputStream(f);

        preparedStatement.setBinaryStream(9,fs,(int)f.length());
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
        preparedStatement.setInt(5, user.getCertificateGrade());
        preparedStatement.setBoolean(6, user.isHasMedal());
        preparedStatement.setLong(7, user.getSpecialtyId());
        preparedStatement.setLong(8, user.getId());

        File f= user.getImage();
        FileInputStream fs=new FileInputStream(f);
        preparedStatement.setBinaryStream(9,fs,(int)f.length());

        preparedStatement.executeUpdate();
        }catch (SQLException | FileNotFoundException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User find(long id) throws DaoException {
        User user = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_USER)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong(ID_COL));
                user.setSurname(resultSet.getString(SURNAME_COL));
                user.setName(resultSet.getString(NAME_COL));
                user.setPatronymic(resultSet.getString(PATRONYMIC_COL));
                user.setPassportNumber(resultSet.getString(PASSPORT_NUM_COL));
                user.setCertificateGrade(resultSet.getInt(CERTIFICATE_COL));
                user.setHasMedal(resultSet.getBoolean(MEDAL_COL));
                user.setSpecialtyId(resultSet.getLong(SPECIALTY_ID_COL));

                File f=new File("src/main/resources/database/images " + user.getId() + ".jpg");
                FileOutputStream fs=new FileOutputStream(f);
                Blob blob=resultSet.getBlob(IMAGE_COL);
                byte[] b=blob.getBytes(1, (int)blob.length());
                fs.write(b);

                user.setImage(f);
            }
            resultSet.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | IOException e) {
            throw new DaoException(e);
        }
        return user;
    }
}
