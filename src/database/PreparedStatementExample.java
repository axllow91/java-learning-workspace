package database;

import java.sql.*;

public class PreparedStatementExample {
    // JDBC Driver Name &  Database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306/mrn?useSSL=false";

    // JDBC Database Credential
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    private static final String SELECTOR_NAME = "SELECT * FROM student WHERE name LIKE ?";

    public static void main(String[] args) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS)

        ) {
            PreparedStatement ps = conn.prepareStatement(SELECTOR_NAME);
            ps.setString( 1,"d%");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                // printing the name from the column name
                System.out.println("Name: " + rs.getString(2) + ", sex: " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
