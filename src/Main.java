import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException { // If you try to connect a database, SQLException will be thrown.
        Connection connection = null;
        DbHelper helper = new DbHelper(); // DbHelper is the class we use to connect database.
        Statement statement = null; // This is SQL statement, which means the operation sentence we use in Mt SQL
        ResultSet resultSet; // this is the set of results (data) we get from the operations in statement;
        try {
            connection = helper.getConnection(); // we used helper, which is an DbHelper object, to connect to database.
            statement = connection.createStatement(); // we should use the connection, to createStatement.
            // (multiple connections might be used in project. So we should use the connection we want to create a statement)
            resultSet = statement.executeQuery("select actor_id, first_name, last_name from sakila.actor");
            while(resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            connection.close(); // don't forget to close the connection.
        }
    }
}