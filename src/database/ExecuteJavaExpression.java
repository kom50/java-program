package database;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;
public class ExecuteJavaExpression {
    public static void main(String[] args) {
        try(JdbcRowSet jRs = RowSetProvider.newFactory().createJdbcRowSet()){
            jRs.setUrl("jdbc:mysql://localhost:3306/pythonDB");  // Set database connection
            jRs.setUsername("root");    // set username of database
            jRs.setPassword("12345om");   // set database password
            // Java mathematical expression
            String exp = "2 + 2 * 21";
            jRs.setCommand("SELECT ("+exp+")");
            jRs.execute();
            jRs.first();
            System.out.println("Result : "+jRs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
