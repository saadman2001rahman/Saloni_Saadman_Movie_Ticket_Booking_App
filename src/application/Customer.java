package application;

public class Customer {
	private int userID;
	private String customerName = "";
	private int age;
	
	private double amountBalance;
	
	public Customer(int id, String name, int age, double amountBalance) {
		this.userID = id;
		this.customerName = name;
		this.age = age;
		this.amountBalance = amountBalance;
	}
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void changeAmountBalance(double balance) {
		this.amountBalance += balance;
	}

	public int getAge() {
		return this.age;
	}
	
	public void bookSeat(Movie movieName, Theater theater, Schedule date, Seat seatNum) {
		BookingSystem book = new BookingSystem();
		try {
			book.bookMovieTicket(name, theater, date, seatNum);
			book.calculateTotalPrice(movieName.getbasePrice());
		}catch (Exception e) {
			
		}
	}
}
