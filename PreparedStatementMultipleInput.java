package JDBC;

import java.util.*;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	public class PreparedStatementMultipleInput {

		
		private static final String INSERT_PREP_USERS_SQL = "INSERT INTO Person1 VALUES (?,?,?,?,?)";
		public static void main(String[] args) {
			
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		System.out.println("enter the number of data want to input");
		int dataNo=scn.nextInt();
		
		
		
		for(int i=1;i<=dataNo;i++)
		{
			System.out.println("***ENTER THE  DATA***");
			
			try (Connection connection = DriverManager
			  .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");
					
			 
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PREP_USERS_SQL)) {
				System.out.println("enter the Personid");
				int id=scn.nextInt();
				
				System.out.println("enter the FirstName");
				String first=scn.next();
				
				System.out.println("enter the LastName");
				String last=scn.next();
				System.out.println("enter the Address");
				String address=scn.next();
				System.out.println("enter the City");
				String city =scn.next();
				
		     preparedStatement.setInt(1, id);
			 preparedStatement.setString(2, first);
			 preparedStatement.setString(3,last );
			 preparedStatement.setString(4, address);
			 preparedStatement.setString(5, city);

			 System.err.println("inserted the data!!!!"+preparedStatement);
			 
			 
			 preparedStatement.executeUpdate();
			 
			 
			} 
			
			
			catch (SQLException e) {
			 
			  	System.err.println("SQLState: " + e.getSQLState());
	            System.err.println("Error Code: " + e.getErrorCode());
	            System.err.println("Message: " + e.getMessage());
	  
			}

		}

	}}