package JDBC;

//package com.clayfin.lesson16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCreate {
	private static final String createTableSQL = "create table Employee11(id  number primary key,name varchar2(20),email varchar2(20),country varchar2(20),  password varchar2(20))";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection connection = DriverManager
	            .getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");

	            // Step 2:Create a statement using connection object
	            Statement statement = connection.createStatement();) {

	            // Step 3: Execute the query or update query
	            statement.execute(JdbcCreate.createTableSQL);
	            System.out.println("table created!");
	        } catch (SQLException e) {

	            // print SQL exception information
	        	System.err.println("SQLState: " + e.getSQLState());
                System.err.println("Error Code: " + e.getErrorCode());
                System.err.println("Message: " + e.getMessage());
	        }
	}

}
