package by.epam.committiee.dao;


import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Dao<Account> {
    private static final String SELECT_ALL_ACCOUNTS = "select * account";
    private static final String INSERT_ACCOUNT = "insert into account(id, login, password, role) values (?,?,?,?)";
    private static final String DELETE_ACCOUNT = "delete from account where id = ? ";
    private static final String UPDATE_ACCOUNT = "UPDATE account SET login = ?,password = ?,role = ? WHERE id = ?";
    private static final String GET_ACCOUNT = "select * from account WHERE id = ?";

    private static final String ID_COL = "id";
    private static final String LOGIN_COL = "login";
    private static final String PASSWORD_COL = "password";
    private static final String ROLE_COL = "role";

    @Override
    public List<Account> getAll() throws DaoException {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ACCOUNTS)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                accounts.add(new Account(rs.getInt(ID_COL),rs.getString(LOGIN_COL),
                      rs.getString(PASSWORD_COL), Role.fromString(rs.getString(ROLE_COL))));
            }
            rs.close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public void save(Account account) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
    PreparedStatement ps = conn.prepareStatement(INSERT_ACCOUNT)) {
        ps.setLong(1, account.getId());
        ps.setString(2, account.getLogin());
        ps.setString(3, account.getPassword());
        ps.setString(4, account.getRole().toString());
        ps.executeUpdate();
    } catch (SQLException e) {
        throw new DaoException(e);
    }
}

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_ACCOUNT)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Account account) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_ACCOUNT)) {
            ps.setString(1, account.getLogin());
            ps.setString(2, account.getPassword());
            ps.setString(3, account.getRole().toString());
            ps.setLong(4, account.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Account get(long id) throws DaoException {
        Account account = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_ACCOUNT)){
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                account = new Account(rs.getInt(ID_COL),rs.getString(LOGIN_COL),
                        rs.getString(PASSWORD_COL), Role.fromString(rs.getString(ROLE_COL)));
            }
            rs.close();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
        return account;
    }

}
