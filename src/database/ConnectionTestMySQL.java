package database;
import java.sql.*;
public class ConnectionTestMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pythonDB";
        String user = "root";
        String pass = "12345om";
        Connection con;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            if (con != null){
                System.out.println("Connected");
                Statement smt = con.createStatement();
                ResultSet rs =  smt.executeQuery("SElect * from student");
                System.out.println("sl no. \t Name\t Roll\t Fees");
                while(rs.next()){
                    System.out.println(rs.getString("stdid")+"\t"+rs.getString("name")+"\t"+
                            rs.getString("roll")+"\t"+rs.getString("fees"));
                }
            }
            else {
                System.out.println("Connection fails");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
