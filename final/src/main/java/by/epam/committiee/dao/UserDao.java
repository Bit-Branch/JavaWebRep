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

    @Override
    public List<User> getAll() throws DaoException {
        List<User> users = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(ID_COL));
                user.setSurname(rs.getString(SURNAME_COL));
                user.setName(rs.getString(NAME_COL));
                user.setPatronymic(rs.getString(PATRONYMIC_COL));
                user.setPassportNumber(rs.getString(PASSPORT_NUM_COL));
                user.setCertificateGrade(rs.getInt(CERTIFICATE_COL));
                user.setHasMedal(rs.getBoolean(MEDAL_COL));
                user.setSpecialtyId(rs.getLong(SPECIALTY_ID_COL));

                File f=new File("src/main/resources/database/images " + user.getId() + ".jpg");
                FileOutputStream fs=new FileOutputStream(f);
                Blob blob=rs.getBlob(IMAGE_COL);
                byte[] b=blob.getBytes(1, (int)blob.length());
                fs.write(b);

                user.setImage(f);
                users.add(user);
            }
            rs.close();
        } catch (SQLException | IOException e) {
            throw new DaoException(e.getMessage());
        }
        return users;
    }

    @Override
    public void save(User user) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER)){
        ps.setLong(1, user.getId());
        ps.setString(2, user.getSurname());
        ps.setString(3, user.getName());
        ps.setString(4, user.getPatronymic());
        ps.setString(5, user.getPassportNumber());
        ps.setInt(6, user.getCertificateGrade());
        ps.setBoolean(7, user.isHasMedal());
        ps.setLong(8, user.getSpecialtyId());

        File f= user.getImage();
        FileInputStream fs=new FileInputStream(f);

        ps.setBinaryStream(9,fs,(int)f.length());
        ps.executeUpdate();
    } catch (SQLException | FileNotFoundException e) {
        throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_USER)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(User user) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_USER)) {
        ps.setString(1, user.getSurname());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPatronymic());
        ps.setString(4, user.getPassportNumber());
        ps.setInt(5, user.getCertificateGrade());
        ps.setBoolean(6, user.isHasMedal());
        ps.setLong(7, user.getSpecialtyId());
        ps.setLong(8, user.getId());

        File f= user.getImage();
        FileInputStream fs=new FileInputStream(f);
        ps.setBinaryStream(9,fs,(int)f.length());

        ps.executeUpdate();
        }catch (SQLException | FileNotFoundException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User get(long id) throws DaoException {
        User user = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_USER)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong(ID_COL));
                user.setSurname(rs.getString(SURNAME_COL));
                user.setName(rs.getString(NAME_COL));
                user.setPatronymic(rs.getString(PATRONYMIC_COL));
                user.setPassportNumber(rs.getString(PASSPORT_NUM_COL));
                user.setCertificateGrade(rs.getInt(CERTIFICATE_COL));
                user.setHasMedal(rs.getBoolean(MEDAL_COL));
                user.setSpecialtyId(rs.getLong(SPECIALTY_ID_COL));

                File f=new File("src/main/resources/database/images " + user.getId() + ".jpg");
                FileOutputStream fs=new FileOutputStream(f);
                Blob blob=rs.getBlob(IMAGE_COL);
                byte[] b=blob.getBytes(1, (int)blob.length());
                fs.write(b);

                user.setImage(f);
            }
            rs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | IOException e) {
            throw new DaoException(e);
        }
        return user;
    }
}
