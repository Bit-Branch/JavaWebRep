package services;

import database.DatabaseManager;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {
    DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();

    @Override
    public List<User> getAll() {
        Connection connection = null;
        List<User> users = null;
        try {
            connection = databaseManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from epam_schema."user"");
            users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"),rs.getString("surname"),
                        rs.getString("name"),rs.getString("patronymic"),
                        rs.getString("passport_number"), rs.getInt("certificate_grade"),
                        rs.getBoolean("medal"),rs.getInt("specialty_id")));
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void save(User user) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into epam_schema.user(id, surname, name, patronymic,passport_number,certificate_grade,medal,specialty_id) values (?,?,?,?,?,?,?,?)");
        ps.setInt(1, user.getId());
        ps.setString(2, user.getSurname());
        ps.setString(3, user.getName());
        ps.setString(4, user.getPatronymic());
        ps.setString(5, user.getPassportNumber());
        ps.setInt(6, user.getCertificateGrade());
        ps.setBoolean(7, user.isHasMedal());
        ps.setInt(8, user.getSpecialtyId());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from epam_schema."user" where id = ? ");
        ps.setInt(1,id);
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void update(User user) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE epam_schema.user SET surname = ?,name = ?,patronymic = ?,passport_number = ?,certificate_grade = ?,medal = ?, specialty_id = ? WHERE id = ?");
        ps.setString(1, user.getSurname());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPatronymic());
        ps.setString(4, user.getPassportNumber());
        ps.setInt(5, user.getCertificateGrade());
        ps.setBoolean(6, user.isHasMedal());
        ps.setInt(7, user.getSpecialtyId());
        ps.setInt(8, user.getId());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public User get(int id){
        Connection connection = null;
        User user = null;
        try {
            connection = databaseManager.getConnection();
            Statement st = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("select * from epam_schema."user" WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"),rs.getString("surname"),
                        rs.getString("name"),rs.getString("patronymic"),
                        rs.getString("passport_number"), rs.getInt("certificate_grade"),
                        rs.getBoolean("medal"),rs.getInt("specialty_id"));
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
