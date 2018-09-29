package photo.dao.connectedFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private final String URL = "jdbc:mysql://localhost:3306/mms";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public Connection getConnect() throws SQLException {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("connected");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("no connected");
        }
        return connection;
    }
}
