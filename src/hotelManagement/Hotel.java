package hotelManagement;

public class Hotel {

	private int customerId;
	private String customerName;
	private long phoneNumber;
	private String roomType;
	private short noOfRooms;
	private int price;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public short getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(short noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Hotel(int customerId, String customerName, long phoneNumber, String roomType, short noOfRooms, int price) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.roomType = roomType;
		this.noOfRooms = noOfRooms;
		this.price = price;
	}
	
	public Hotel( String customerName, long phoneNumber, String roomType, short noOfRooms, int price) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.roomType = roomType;
		this.noOfRooms = noOfRooms;
		this.price = price;
	}
	
	
}
