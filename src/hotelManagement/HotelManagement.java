package hotelManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelManagement {

	public boolean insertCustomerDetail(Hotel h)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {

		String query = "INSERT INTO hotel (customerName, phoneNumber, roomType, numberOfRooms, price) VALUES (?, ?, ?, ?, ?)";

		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, h.getCustomerName());
			ps.setLong(2, h.getPhoneNumber());
			ps.setString(3, h.getRoomType());
			ps.setShort(4, h.getNoOfRooms());
			ps.setInt(5, h.getPrice());

			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		}
	}

	public void viewTable() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		String query = "Select * from hotel";
		try (Connection con = DB.getConnections();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			if (!rs.isBeforeFirst()) {
				System.out.println("Table is Empty");
			}

			else {
				System.out.println("HOTEL TABLE");
				System.out.println("----------------------------------------------");
				while (rs.next()) {
					System.out.println("Customer ID:" + rs.getInt("id"));
					System.out.println("Customer Name:" + rs.getString("customerName"));
					System.out.println("Phone Number:" + rs.getString("phoneNumber"));
					System.out.println("Room Type:" + rs.getString("roomType"));
					System.out.println("Number of Rooms:" + rs.getInt("numberOfRooms"));
					System.out.println("Price:" + rs.getDouble("price"));
					System.out.println();
				}
			}
		}
	}

	public boolean deleteRecord(int idDelete)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		String query = "Delete from hotel where id=?";
		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idDelete);
			int rowsAffected = ps.executeUpdate();
			return rowsAffected > 0;
		}
	}

	public void searchDetail(int idSearch)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		String query = "Select * from hotel where id=?";
		try (Connection con = DB.getConnections(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, idSearch);
			try (ResultSet rs = ps.executeQuery()) {
				if (!rs.isBeforeFirst()) {
					System.out.println("No such ID found\n");
				} else {
					while (rs.next()) {
						System.out.println("Customer ID:" + rs.getInt("id"));
						System.out.println("Customer Name:" + rs.getString("customerName"));
						System.out.println("Phone Number:" + rs.getString("phoneNumber"));
						System.out.println("Room Type:" + rs.getString("roomType"));
						System.out.println("Number of Rooms:" + rs.getInt("numberOfRooms"));
						System.out.println("Price:" + rs.getDouble("price"));
						System.out.println();
					}
				}
			}
		}
	}

	public double totalRvenue() throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {
		double grandTotal=0.0;
		String query="Select price from Hotel";
		try(Connection con=DB.getConnections();PreparedStatement ps=con.prepareStatement(query);ResultSet rs=ps.executeQuery()){
			if(!rs.isBeforeFirst()) {
				System.out.println("Table is Empty\n");
			}
			else {
				while(rs.next()) {
					grandTotal+=rs.getDouble("price");
				}
			}
		}
		return grandTotal;
	}

}
