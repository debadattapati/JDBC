package JDBC;

import java.sql.*;

public class Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try	{
			
			Connection conn = 
			DriverManager.getConnection (
					"jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","Pati@2000");

			
			Statement stmt = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			ResultSet rset = stmt.executeQuery ("select id,name from Employee11");
			
			System.out.println("Employee No             Employee Name");
			System.out.println("_______________________________________");
			while (rset.next()) {
				System.out.println (rset.getInt (1)+"                       "+rset.getString (2));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
