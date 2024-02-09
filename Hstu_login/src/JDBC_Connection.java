import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_Connection {


    static String url = "jdbc:mysql://localhost:3306/student";
    public static String username = "root";
    public static String password = "password";
    public static Connection getConnection(){
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,username,password);
           // System.out.println("successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return connection;
    }

}
