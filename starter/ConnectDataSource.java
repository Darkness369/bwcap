package starter;

/**
 *
 * @author Blueweb
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import starter.PoolDB;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
@WebServlet (name="name of servlet",urlPatterns={"/url patter of servlet"})
public class ConnectDataSource {
    
    public static void main(String[] args) throws SQLException, NamingException {
    //main m = new main();
    PoolDB cn = new PoolDB();
   
       // Create datasource.
        

       
        try (Connection con = cn.getConnection("Activa");
                Statement stmt = con.createStatement();
                
                ) {
            String SQL = "SELECT * FROM dbo.C_CLIENTES";
            // Execute a stored procedure that returns some data
            ResultSet rs = stmt.executeQuery(SQL);
            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("NOMBRE_CLIENTE") + " ");
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
        }
    }
}