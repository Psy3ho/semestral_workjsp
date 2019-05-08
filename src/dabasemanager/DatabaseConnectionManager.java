package dabasemanager;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnectionManager {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            String connectionURL = "jdbc:mysql://localhost:3306/finaldb?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(connectionURL, "root", "");

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return connection;
    }

}
