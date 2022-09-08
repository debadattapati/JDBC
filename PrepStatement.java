package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepStatement {
	
	private static final String INSERT_PREP_USERS_SQL = "INSERT INTO Person VALUES (?,?,?,?,?)";
	public static void main(String[] args) {
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager
		  .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");
				
		 
		 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PREP_USERS_SQL)) {
		 preparedStatement.setInt(1, 1);
		 preparedStatement.setString(2, "Tony");
		 preparedStatement.setString(3, "tony@gmail.com");
		 preparedStatement.setString(4, "US");
		 preparedStatement.setString(5, "secret");

		 System.out.println("inserted the data!!!!"+preparedStatement);
		 
		 preparedStatement.executeUpdate();
		 
		
		} 
		
		
		catch (SQLException e) {
		 
		  	System.err.println("SQLState: " + e.getSQLState());
            System.err.println("Error Code: " + e.getErrorCode());
            System.err.println("Message: " + e.getMessage());
  
		}

	}

}
