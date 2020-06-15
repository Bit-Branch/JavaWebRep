package by.epam.committiee.dao.impl;


import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements Dao<Account> {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_ACCOUNTS = "select * account";
    private static final String INSERT_ACCOUNT = "insert into account(id, login, password, role) values (?,?,?,?)";
    private static final String DELETE_ACCOUNT = "delete from account where id = ? ";
    private static final String UPDATE_ACCOUNT = "UPDATE account SET login = ?,password = ?,role = ? WHERE id = ?";
    private static final String GET_ACCOUNT = "select * from account WHERE id = ?";
    private static final String GET_ACCOUNT_BY = "select * from account WHERE login = ? and password = ?";

    private static final String ID_COLUMN = "id";
    private static final String LOGIN_COLUMN = "login";
    private static final String PASSWORD_COLUMN = "password";
    private static final String ROLE_COLUMN = "role";

    private static final AccountDao instance = new AccountDao();

    private AccountDao(){}

    public static AccountDao getInstance() {
        return instance;
    }

    @Override
    public List<Account> findAll() throws DaoException {
        List<Account> accounts = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ACCOUNTS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                accounts.add(new Account(resultSet.getInt(ID_COLUMN),resultSet.getString(LOGIN_COLUMN),
                      resultSet.getString(PASSWORD_COLUMN), Role.valueOf(resultSet.getString(ROLE_COLUMN))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
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
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ACCOUNT);
             ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getInt(ID_COLUMN),resultSet.getString(LOGIN_COLUMN),
                        resultSet.getString(PASSWORD_COLUMN), Role.valueOf(resultSet.getString(ROLE_COLUMN)));
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
        return account;
    }

    public Account findBy(String login,String password) throws DaoException{
        Account account = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ACCOUNT_BY)){
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                account = new Account(resultSet.getInt(ID_COLUMN),resultSet.getString(LOGIN_COLUMN),
                        resultSet.getString(PASSWORD_COLUMN), Role.valueOf(resultSet.getString(ROLE_COLUMN)));
            }
            resultSet.close();
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
        return account;
    }

}
