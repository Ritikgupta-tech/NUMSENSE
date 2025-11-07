package nums;


import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/numsense_db";
    private static final String USER = "root";
    private static final String PASS = "273010";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

