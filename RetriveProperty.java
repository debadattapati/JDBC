package JDBC;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RetriveProperty {

	public static void main(String[] args) throws IOException, SQLException  {
		
FileReader fr=new FileReader("prop.properties");
BufferedReader br= new BufferedReader(fr);
Properties pr=new Properties();
pr.load(br);

String url=(String)pr.get("url");
String user=(String)pr.get("user");
String passward=(String)pr.get("passward");

System.out.println(url);
System.out.println(user);
System.out.println(passward);
try(Connection con=DriverManager.getConnection(url, user, passward);
		Statement statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);)
{
	ResultSet rs=statement.executeQuery("select * from Employee12");
	System.out.println("moving in forward direction");
	while(rs.next())
	{
		System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
	}
	
	}
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}

}
