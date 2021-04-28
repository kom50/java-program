package database;
import java.sql.Connection;
import java.sql.DriverManager;
public class Connect {
    //  Connection to Oracle database
    public static Connection connectOracle(String user, String pass) {
        Connection con = null;
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, user, pass);
            if (con != null)
                System.out.println("Connection successful.");
        } catch (Exception e) {
            System.out.println("Unable to connect.");
            System.out.println("Error " + e);
            return null;
        }
        return con;
    }

    // Connection to MySQL database
    public static Connection connectMySQL(String user, String pass, String database) {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/"+database;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            if (con != null)
                System.out.println("Connection successful.");
        } catch (Exception e) {
            System.out.println("Unable to connect.");
            System.out.println("Error " + e);
            return null;
        }
        return con;
    }
}
