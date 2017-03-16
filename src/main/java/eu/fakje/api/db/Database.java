package eu.fakje.api.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
    private static final String url = "jdbc:mysql://localhost:3306/fakje";
    private static final String username = "root";
    private static final String password = "d3v";

    public static Connection getDBConnection()
    {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection to db established");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
