package co.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory 
{
	private static Connection connection=null;
	public static Connection getConnection() 
	{
		if(connection==null)
		{
			ResourceBundle bundle=ResourceBundle.getBundle("db");
			String driver=bundle.getString("driver");
			String url=bundle.getString("url");
			String uid=bundle.getString("user");
			String pwd=bundle.getString("password");
			
			try {
				Class.forName(driver);
				connection=DriverManager.getConnection(url,uid,pwd);
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
}
