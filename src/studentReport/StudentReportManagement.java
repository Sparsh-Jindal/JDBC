package studentReport;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentReportManagement {

//This method check if the table is empty or not 
	public boolean ifEmpty() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		String query = "select * from student_details";
		try (Connection con = DB.getConnections();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			return !rs.isBeforeFirst();
		}

	}

// This method is used to Insert values in the table
	public boolean addStudent(Student s)
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		String query = "Insert into student_details (rollNumber,name,age,course,marks) values(?,?,?,?,?) ";

		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {

			ps.setInt(1, s.getRollNumber());
			ps.setString(2, s.getName());
			ps.setInt(3, s.getAge());
			ps.setString(4, s.getCourse());
			ps.setDouble(5, s.getMarks());

			int ifAdded = ps.executeUpdate();

			return ifAdded > 0;

		}
	}

// This method is used to View full student details
	public void viewStudent() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		String query = "Select * from student_details";
		try (Connection con = DB.getConnections();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();) {

			if (!rs.isBeforeFirst()) { // checks if the ResultSet is empty
				System.out.println("\nTable is empty.");
				return;
			}
			System.out.println("\nSTUDENT TABLE");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("ID\tName\tAge\tCourse\tMarks");
			while (rs.next()) {
				System.out.print(rs.getInt("rollNumber") + "\t" + rs.getString("name") + " \t " + rs.getInt("Age")
						+ "\t" + rs.getString("course") + "\t" + rs.getDouble("marks"));
				System.out.println();
			}

		}
	}

//This method is used to delete a specific student detail
	public boolean deleteSpecific(int rollNumber)
			throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {

		String query = "Delete from student_details where rollNumber=?";
		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, rollNumber);
			int ifDeleted = ps.executeUpdate();
			return ifDeleted > 0;

		}
	}

	public boolean updateMarks(int rollNumber, Double marks) throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {

		String query = "UPDATE student_details SET marks = ? WHERE rollNumber = ?";
		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {
			
			ps.setDouble(1, marks);
			ps.setInt(2,rollNumber);
			int ifUpdated=ps.executeUpdate();
			
			return ifUpdated>0;
		}

	}

}
