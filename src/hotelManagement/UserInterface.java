package hotelManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInterface {
	static Scanner sc = new Scanner(System.in);

	public static int priceCalculator(String roomType, short noOfRooms) {
		int price = 10000;
		if (roomType.equals("Standard")) {
			price = 3000;
		} else if (roomType.equals("Deluxe")) {
			price = 5000;
		} else if (roomType.equals("Suite")) {
			price = 8000;
		}

		return price * noOfRooms;
	}

	public static Hotel createBooking() {

		System.out.println("Enter the Costumer Name");
		String customerName = sc.nextLine();

		long phoneNumber = 0;
		String phoneRegex = "[6-9]\\d{9}";
		boolean isValidPhone = false;

		while (!isValidPhone) {
			System.out.println("Enter your phone number:");
			String input = sc.nextLine();

			if (input.matches(phoneRegex)) {
				phoneNumber = Long.parseLong(input); // convert only if valid
				isValidPhone = true;
			} else {
				System.out.println("Invalid phone number. Please enter a valid 10-digit Indian mobile number.");
			}
		}

		String roomType = "";//Empty String
		boolean isValidRoom = false;

		System.out.println("Select your room type");
		while (!isValidRoom) {

			System.out.println("1.Standard – ₹3,000 per room per night");
			System.out.println("2.Deluxe – ₹5,000 per room per night");
			System.out.println("3.Suite – ₹8,000 per room per night");
			roomType = sc.nextLine();
			if (roomType.equals("Deluxe") || roomType.equals("Suite") || roomType.equals("Standard")) {
				isValidRoom = true;
			} else {
				System.out.println("Enter a valid Room Type");
			}

		}

		short noOfRooms = 0;
		System.out.println("Enter number of rooms you want");
		while (noOfRooms <= 0) {
			noOfRooms = Short.parseShort(sc.nextLine());
			if (noOfRooms <= 0) {
				System.out.println("Enter the valid number of rooms");
			}
		}

		int price = priceCalculator(roomType, noOfRooms);

		Hotel h = new Hotel(customerName, phoneNumber, roomType, noOfRooms, price);
		return h;
	}

	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, SQLException, IOException {

		int choice = 0;
		HotelManagement hm = new HotelManagement();
		do {

			System.out.println("1.Create a Booking");
			System.out.println("2.View Hotel Table");
			System.out.println("3.Delete though ID");
			System.out.println("4.Search Customer Detail through ID");
			System.out.println("5.Total Hotel Revenue");
			System.out.println("6.Exit");
			System.out.println("Enter the choice");
			choice = Integer.parseInt(sc.nextLine());

			switch (choice) {

			case 1:
				Hotel h = createBooking();
				boolean isAdded = hm.insertCustomerDetail(h);
				if (isAdded) {
					System.out.println("Successfully Inserted");
				} else {
					System.out.println("Unseccesfully in Inserting Details");
				}
				break;
				
			case 2:
				hm.viewTable();
				System.out.println();
				break;
			
			case 3:
				System.out.println("Enter the ID");
				int idDelete=Integer.parseInt(sc.nextLine());
				boolean isDeleted=hm.deleteRecord(idDelete);
				
				if(isDeleted) {
					System.out.println("Customer Details of "+idDelete+" is Delted Successfully\n");
				}
				else {
					System.out.println("No such ID found\n");
				}
				break;
				
			case 4:
				System.out.println("Enter the ID");
				int idSearch=Integer.parseInt(sc.nextLine());
				hm.searchDetail(idSearch);
				break;
			case 5:
				double grandTotal=hm.totalRvenue();
				System.out.println("Total Income of the Hotel:"+grandTotal+"\n");
				break;
			case 6:
				System.out.println("Thanks for using this applicatation");
				break;
			default :
				System.out.println("Invalid Choice");
			}

		} while (choice != 6);
	}

}
