package database;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
public class JdbcRowSetDemo {
    public static void main(String[] args) {
        try(JdbcRowSet jRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jRs.setUrl("jdbc:mysql://localhost:3306/pythonDB");  // Set database connection
            jRs.setUsername("root");    // set username of database
            jRs.setPassword("12345om");   // set database password

            // set SQL query
            jRs.setCommand("SELECT *FROM student");
            jRs.execute();
//            System.out.println(jRs.getRow());
            System.out.println(jRs.getFetchSize());
            System.out.println(jRs.getMaxRows());
//            jRs.last();

            while(jRs.next())
            {
                System.out.println(jRs.getInt(1)+"  "+jRs.getString(2));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
