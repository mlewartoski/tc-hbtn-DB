import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {
    public static void initConnection(){
        try {
            String url = "jdbc:sqlite:sqlite_database_2022.db";
            DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initConnection();
    }
}
