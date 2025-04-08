package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//1.Register Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish the connection 
		//                                                  url of database            username     password
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/myDb1","root","Swati143");
		System.out.println("Connection is established successfully");
		
		//3.Create Statement 
		
//		Statement st=con.createStatement();
//		
//		st.execute("insert into employee(id,name,salary) values(101,'Sparsh',200000000)");
//		System.out.println("Data is inserted");
//		st.execute("insert into employee(id,name,salary) values(102,'Swati',1)");
//		System.out.println("Data is inserted");
//		
//		st.execute("delete from employee where id=101 limit 1");
//		System.out.println("1 row Deleted");
		
			
		
	}

}
