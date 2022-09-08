package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsetBackward {

	public static void main(String[] args) {
		try(Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Pati@2000");
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);)
		{
			ResultSet rs=statement.executeQuery("select * from Employee12");
			System.out.println("moving in forward direction");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
			}
			System.out.println("moving in Backward direction");
			while(rs.previous())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
