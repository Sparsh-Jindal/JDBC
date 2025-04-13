package hotelManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static String driver="";
	private static String url="";
	private static String username="";
	private static String password="";
	
	static Connection con=null;
	static Properties props= new Properties();
	
	public static Connection getConnections()
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		try(FileInputStream fis =new FileInputStream("database.properties")){
			props.load(fis);
			driver=props.getProperty("DB_DRIVER_CLASS");
			Class.forName(driver);
			
			url=props.getProperty("DB_URL");
			username=props.getProperty("DB_USERNAME");
			password=props.getProperty("DB_PASSWORD");
			
			con=DriverManager.getConnection(url,username,password);
			
		}		
		return con;
	}
}
