import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String userName = "root";
    private String password = "2405";
    private String dbUrl = "jdbc:mysql://localhost:3306/sakila"; //dbUrl ise the variable we use to store table's location that we try to access.

    public Connection getConnection() throws SQLException { // this function connects the database with the given parameters in 11.
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    public void showErrorMessage(SQLException exception) { // This function show the error message.
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error code: " + exception.getErrorCode());
    }
}
