package chat.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zsolt on 09/03/16.
 */
public class SetUpDBConnection {

    private static Connection connection;

    public SetUpDBConnection(Connection connection){
        this.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    /**
     * Sets up a connection to the database using Zsolt's defaults
     * (no separate .properties file implemented yet, please
     * change locally if it doesn't work)
     * @throws SQLException
     */
    public void initiate() throws SQLException {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://dbteach2.cs.bham.ac.uk/team_athens",
                        "zxp590", "pizza");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(!connection.isClosed()) {
            System.out.println("Connected to database.");
        }

    }

    public static void main(String[] args) throws SQLException {
        SetUpDBConnection setup = new SetUpDBConnection(connection);
        setup.initiate();
    }
}
