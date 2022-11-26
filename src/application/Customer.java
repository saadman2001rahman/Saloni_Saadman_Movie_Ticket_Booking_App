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
	
	public String getCustName() {
		return this.customerName;
	}
	
	public void changeAmountBalance(double balance) {
		this.amountBalance += balance;
	}

	public int getAge() {
		return this.age;
	}
	
	public void bookSeat(Movie movieName, Theater theater, Schedule date, Seat seatnum) {
		BookingSystem book = new BookingSystem();
		try {
			book.bookMovieTicket(this.customerName, theater, date, seatNum);
			book.calculateTotalPrice(movieName.getbasePrice());
		}catch (Exception e) {
			
		}
	}
}
