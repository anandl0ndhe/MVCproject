package in.anand.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	public static Connection getconnection() {
		Connection con=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mvcdb","root","root");
		
		}
		catch(SQLException | ClassNotFoundException e) 
		{
			e.printStackTrace();	
		}
		return con;
		
	}
}
