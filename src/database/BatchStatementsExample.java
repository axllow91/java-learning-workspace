package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStatementsExample {
    // JDBC Driver Name & Database URL
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mrn?useSSL=false";

    // Insert Query
    private static final String INSERT_VALUES1 = "INSERT INTO student(name, sex) VALUES('Mitica Sula', 'M')";
    private static final String INSERT_VALUES2 = "INSERT INTO student(name, sex) VALUES('Didica Ciulica', 'F')";

    // Update Query
    private static final String UPDATE_QUERY = "UPDATE student SET name = 'Dubre Marian' WHERE id = 1";

    // JDBC Database Credential
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "root";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
            Statement stmt = conn.createStatement()
        ) {
            conn.setAutoCommit(false);

            stmt.addBatch(INSERT_VALUES1);
            stmt.addBatch(INSERT_VALUES2);
            stmt.addBatch(UPDATE_QUERY);

            // execute batch
            int[] recordsAffected = stmt.executeBatch();
            System.out.println(recordsAffected.length);
            conn.commit();
            System.out.println("successful Operation");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
