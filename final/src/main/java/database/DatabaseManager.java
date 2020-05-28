package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DatabaseManager {

    private Connection connection = null;
    private Statement state = null;
    private static DatabaseManager databaseManager = null;

    private DatabaseManager() {
        try {
            connection = this.getConnection();
            createTables();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Не удалось установить соединение с базой данных");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("Установлено соединение с базой данных");
        } else {
            System.out.println("Не удалось установить соединение, возможно базы данных не сущестует");
        }
    }

    public static DatabaseManager getDatabaseManager(){
        if(databaseManager == null)
            databaseManager = new DatabaseManager();
        return databaseManager;
    }

    public void disconnectDatabase() {
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }

    public void createTables() {
        try {
            Scanner in = new Scanner(getClass().getResourceAsStream("/resources/CreateDBwithTables.sql"),"UTF-8");
            in.useDelimiter(";");
            state = connection.createStatement();
            while (in.hasNext()){
                String sqlData = in.next().trim();
                if (!sqlData.isEmpty()){
                    state.execute(sqlData);
                }
            }
            in.close();
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost/";
        Properties p =new Properties();
        p.setProperty("user","root");
        p.setProperty("password","8337");
        p.setProperty("useUnicode","true");
        p.setProperty("characterEncoding","cp1251");
        Connection connection = DriverManager.getConnection(url,p);
        return connection;
    }

    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        //databaseManager.createTables();
        databaseManager.disconnectDatabase();
    }
}
