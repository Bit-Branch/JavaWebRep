package services;

import database.DatabaseManager;
import model.Account;
import model.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Dao<Account> {
    DatabaseManager databaseManager = DatabaseManager.getDatabaseManager();

    @Override
    public List<Account> getAll() {
        Connection connection = null;
        List<Account> accounts = null;
        try {
            connection = databaseManager.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from epam_schema.account");
            accounts = new ArrayList<>();
            while (rs.next()) {
                accounts.add(new Account(rs.getInt("id"),rs.getString("login"),
                        rs.getString("password"), Role.fromString(rs.getString("role"))));
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void save(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into epam_schema.account(id, login, password, role) values (?,?,?,?)");
        ps.setInt(1, account.getId());
        ps.setString(2, account.getLogin());
        ps.setString(3, account.getPassword());
        ps.setString(4,account.getRole().toString());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from epam_schema.account where id = ? ");
        ps.setInt(1,id);
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public void update(Account account) throws SQLException, ClassNotFoundException {
        Connection connection = databaseManager.getConnection();
        PreparedStatement ps = connection.prepareStatement("UPDATE epam_schema.account SET login = ?,password = ?,role = ? WHERE id = ?");
        ps.setString(1, account.getLogin());
        ps.setString(2, account.getPassword());
        ps.setString(3,account.getRole().toString());
        ps.setInt(4, account.getId());
        ps.executeUpdate();
        connection.close();
    }

    @Override
    public Account get(int id){
        Connection connection = null;
        Account account = null;
        try {
            connection = databaseManager.getConnection();
            Statement st = connection.createStatement();
            PreparedStatement ps = connection.prepareStatement("select * from epam_schema.account WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt("id"),rs.getString("login"),
                        rs.getString("password"), Role.fromString(rs.getString("role")));
            }
            rs.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }
}
