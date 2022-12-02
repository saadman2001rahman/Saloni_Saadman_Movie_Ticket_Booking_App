package application;

public class Customer {
	private String userID;
	private String customerName = "";
	private int age;
	
	private double amountBalance;
	
	public Customer(String id, String name, int age, double amountBalance) {
		this.userID = id;
		this.customerName = name;
		this.age = age;
		this.amountBalance = amountBalance;
	}
	
	public String getCustName() {
		return this.customerName;
	}
	
	public void changeAmountBalance(double balance) {
		this.amountBalance += balance;
	}

	public int getAge() {
		return this.age;
	}
	
//	public void bookSeat(Movie movieName, Theater theater, Schedule date, Seat seatnum) {
//		BookingSystem book = new BookingSystem();
//		try {
//			book.bookMovieTicket(customerName, theater, date, seatnum);
//			book.calculateTotalPrice(movieName.getbasePrice());
//		}catch (Exception e) {
//			
//		}
//	}
}
