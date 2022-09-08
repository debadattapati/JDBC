package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetSetSensitive {

	public static void main(String[] args) 
	{
		try( Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Pati@2000");
		Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);)
		{
			ResultSet rs=stmt.executeQuery("select * from Employee11");
			int temp=0;
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
				if(temp!=0)
				{
					Thread.sleep(4500);
				}
				temp++;
			}
			
		} catch (SQLException | InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
