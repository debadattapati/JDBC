package JDBC;

//package com.clayfin.lesson16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MultiInsertJdbc {
	private static final String INSERT_MULTIPLE_USERS_SQL = "INSERT INTO Employee11 VALUES(90, 'aasay', 'shy@gmail.com', 'Indpfistan', 'aghcde')";
			
	     
	        //"(4, 'diva', 'diva@gmail.com', 'India', 'bbbbb')," + "(55, 'jay', 'jay@gmail.com', 'India', 'rrrrr');";
	
	public static void main(String[] args) {
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");

		            // Step 2:Create a statement using connection object
		            Statement statement = connection.createStatement();) {

		            // Step 3: Execute the query or update query
		            int result = statement.executeUpdate(INSERT_MULTIPLE_USERS_SQL);
		            System.out.println("No. of records affected : " + result);
		        } catch (SQLException e) {

		            // print SQL exception information
		        	System.err.println("SQLState: " + e.getSQLState());
	                System.err.println("Error Code: " + e.getErrorCode());
	                System.err.println("Message: " + e.getMessage());
		    
		        }

	}

}




