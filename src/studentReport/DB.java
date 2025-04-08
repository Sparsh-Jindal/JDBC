package studentReport;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

	private static String db_class = "";
	private static String db_url = "";
	private static String db_username = "";
	private static String db_password = "";
	
	private static Connection con = null;
	private static Properties props = new Properties();

	public static Connection getConnections() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		
		try(FileInputStream fis= new FileInputStream("database.properties")){
			
			props.load(fis);
			db_class=props.getProperty("DB_DRIVER_CLASS");
			Class.forName(db_class);
			
			db_url=props.getProperty("DB_URL");
			db_username=props.getProperty("DB_USERNAME");
			db_password=props.getProperty("DB_PASSWORD");
			
			
			con=DriverManager.getConnection(db_url,db_username,db_password);
			
			 return con;
		}

	}
}
