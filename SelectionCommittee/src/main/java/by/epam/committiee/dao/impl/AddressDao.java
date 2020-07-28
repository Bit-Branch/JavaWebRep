package by.epam.committiee.dao.impl;

import by.epam.committiee.dao.Dao;
import by.epam.committiee.entity.Account;
import by.epam.committiee.entity.Address;
import by.epam.committiee.entity.Role;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements Dao<Address> {
//    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String SELECT_ALL_ADDRESSES = "select id,locality,street,building,flat,zip_code,enrollee_id as salt,role,email from address";
    private static final String INSERT_ADDRESS = "insert into address(id,locality,street,building,flat,zip_code,enrollee_id) values (?,?,?,?,?,?,?)";
    private static final String DELETE_ADDRESS = "delete from address where id = ? ";
    private static final String UPDATE_ADDRESS = "UPDATE address SET locality = ?,street = ?,building = ?,  flat = ?, zip_code = ?, enrollee_id = ? WHERE id = ?";
    private static final String GET_ADDRESS = "select id,locality,street,building,flat,zip_code,enrollee_id from address WHERE id = ?";
    private static final String GET_ADDRESS_BY_USER_ID = "select id,locality,street,building,flat,zip_code,enrollee_id from address WHERE enrollee_id = ?";


    private static final String ID_COLUMN = "id";
    private static final String LOCALITY_COLUMN = "locality";
    private static final String STREET_COLUMN = "street";
    private static final String BUILDING_COLUMN = "building";
    private static final String FLAT_COLUMN = "flat";
    private static final String ZIP_CODE_COLUMN = "zip_code";
    private static final String ENROLLEE_ID_COLUMN = "enrollee_id";

    private static final AddressDao instance = new AddressDao();

    private AddressDao(){}

    public static AddressDao getInstance() {
        return instance;
    }

    @Override
    public List<Address> findAll() throws DaoException {
        List<Address> addresses = new ArrayList<>();
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = conn.prepareStatement(SELECT_ALL_ADDRESSES);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                addresses.add(new Address(resultSet.getInt(ID_COLUMN),resultSet.getString(LOCALITY_COLUMN),
                        resultSet.getString(STREET_COLUMN), resultSet.getString(BUILDING_COLUMN),
                        resultSet.getString(FLAT_COLUMN), resultSet.getString(ZIP_CODE_COLUMN),
                        resultSet.getLong(ENROLLEE_ID_COLUMN)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return addresses;
    }

    @Override
    public void save(Address address) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ADDRESS)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getLocality());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4,address.getBuilding());
            preparedStatement.setString(5,address.getFlat());
            preparedStatement.setString(6, address.getZipCode());
            preparedStatement.setLong(7, address.getEnrolleeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(long id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ADDRESS)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Address address) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ADDRESS)) {
            preparedStatement.setString(1, address.getLocality());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3,address.getBuilding());
            preparedStatement.setString(4,address.getFlat());
            preparedStatement.setString(5, address.getZipCode());
            preparedStatement.setLong(6, address.getEnrolleeId());
            preparedStatement.setLong(7, address.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Address find(long id) throws DaoException {
        Address address = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ADDRESS);
        ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address(resultSet.getInt(ID_COLUMN),resultSet.getString(LOCALITY_COLUMN),
                        resultSet.getString(STREET_COLUMN), resultSet.getString(BUILDING_COLUMN),
                        resultSet.getString(FLAT_COLUMN), resultSet.getString(ZIP_CODE_COLUMN),
                        resultSet.getLong(ENROLLEE_ID_COLUMN));
            }
        }catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
               //     logger.error("Can't close result set: ", e);
                }
            }
        }
        return address;
    }

    public Address findByUserId(long id) throws DaoException {
        Address address = null;
        ResultSet resultSet = null;
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(GET_ADDRESS_BY_USER_ID);
        ){
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                address = new Address(resultSet.getInt(ID_COLUMN),resultSet.getString(LOCALITY_COLUMN),
                        resultSet.getString(STREET_COLUMN), resultSet.getString(BUILDING_COLUMN),
                        resultSet.getString(FLAT_COLUMN), resultSet.getString(ZIP_CODE_COLUMN),
                        resultSet.getLong(ENROLLEE_ID_COLUMN));
            }
        }catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                 //   logger.error("Can't close result set: ", e);
                }
            }
        }
        return address;
    }
}
