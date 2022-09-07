package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreation {
	private static final String createTableSQL = "create table Employee11(id  number primary key,name varchar2(20),email varchar2(20),country varchar2(20),  password varchar2(20))";
	public static void main(String[] args) {
		
		try (Connection connection = DriverManager
	            .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");

	            Statement statement = connection.createStatement();) {

	            
	            statement.execute(JdbcCreate.createTableSQL);
	            System.out.println("table created!");
	        } catch (SQLException e) {

	           
	        	System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());
	        }
	}

}
