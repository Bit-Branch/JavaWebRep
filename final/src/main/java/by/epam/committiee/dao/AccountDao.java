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
    private static final String GET_ACCOUNT_BY = "select * from account WHERE login = ? and password = ?";

    private static final String ID_COL = "id";
    private static final String LOGIN_COL = "login";
    private static final String PASSWORD_COL = "password";
    private static final String ROLE_COL = "role";

    private static final AccountDao instance = new AccountDao();

    private AccountDao(){}

    public static AccountDao getInstance() {
        return instance;
    }

    @Override
    public List<Account> getAll() throws DaoException {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ACCOUNTS)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accounts.add(new Account(resultSet.getInt(ID_COL),resultSet.getString(LOGIN_COL),
                      resultSet.getString(PASSWORD_COL), Role.fromString(resultSet.getString(ROLE_COL))));
            }
            resultSet.close();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
        return accounts;
    }

    @Override
    public void save(Account account) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
    PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ACCOUNT)) {
        preparedStatement.setLong(1, account.getId());
        preparedStatement.setString(2, account.getLogin());
        preparedStatement.setString(3, account.getPassword());
        preparedStatement.setString(4, account.getRole().toString());
        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new DaoException(e);
    }
}

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ACCOUNT)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Account account) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNT)) {
            preparedStatement.setString(1, account.getLogin());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getRole().toString());
            preparedStatement.setLong(4, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Account find(long id) throws DaoException {
        Account account = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ACCOUNT)){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
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

    public Account findBy(String login,String password) throws DaoException{
        Account account = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ACCOUNT_BY)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
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
