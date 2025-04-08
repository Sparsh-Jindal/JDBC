package jdbcOnlineYT;

import java.sql.*;

public class Main {

	private static final String url = "jdbc:mysql://localhost:3306/myDb1";
	private static final String username = "root";
	private static final String password = "Swati143";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

		String query = "insert into students (name,age,marks) VALUES (?,?,?)";
		String read = "select * from students";

		try (Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement prps = con.prepareStatement(query)) {
			prps.setString(1, "Anubhav");
			prps.setInt(2, 22);
			prps.setDouble(3, 69);
			int toCheck = prps.executeUpdate();
//			ResultSet rs = prps.executeQuery();

//			while (rs.next()) {
//				int id = rs.getInt("id");
//				String name = rs.getString("name");
//				int age = rs.getInt("age");
//				double marks = rs.getDouble("marks");
//				System.out.println("ID=" + id);
//				System.out.println("Name=" + name);
//				System.out.println("Age=" + age);
//				System.out.println("Marks=" + marks);
//				System.out.println();
//			}

			if (toCheck > 0) {
				System.out.println("DONE");
			} else {
				System.out.println("Opps");
			}
		}
	}

}
