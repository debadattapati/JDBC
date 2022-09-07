package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJdbc {
	private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO Employee11 VALUES(90, 'aasay', 'shy@gmail.com', 'Indpfistan', 'aghcde')";
			
	      public static void main(String[] args) {
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");

		           
		            Statement statement = connection.createStatement();) {

		           
		            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
		            System.out.println("No. of records affected : " + result);
		        } catch (SQLException e) {

		         
		        	System.err.println("SQLState: " + e.getSQLState());
	                System.err.println("Error Code: " + e.getErrorCode());
	                System.err.println("Message: " + e.getMessage());
		    
		        }

	}

}




