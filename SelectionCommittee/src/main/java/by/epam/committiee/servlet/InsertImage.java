package by.epam.committiee.servlet;

import by.epam.committiee.entity.Account;
import by.epam.committiee.exception.DaoException;
import by.epam.committiee.pool.ConnectionPool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImage {
    private static final String UPDATE_ACCOUNT = "UPDATE account SET image = ? WHERE id = ?";

    public static void main(String[] args) {
        try {
            save(1);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public static void save(int id) throws DaoException {
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNT)) {
            File file= new File("F:\\EpamGitRep\\SelectionCommittee\\src\\main\\resources\\t4.png");
                preparedStatement.setBinaryStream(1,new FileInputStream(file), (int) file.length());
            preparedStatement.setLong(2, id);


            preparedStatement.executeUpdate();
        } catch (SQLException | FileNotFoundException e) {
            throw new DaoException(e);
        }
    }
}
