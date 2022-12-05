package application;

public class Customer extends User{
	private double amountBalance;
	
	public Customer(String id, String name, int age, double amountBalance) {
		super(id, name, age);
		this.amountBalance = amountBalance;
	}
	
	public double getAmountBalance() {
		return this.amountBalance;
	}
	
	public Boolean hasEnoughBalance (double totalPrice) {
		if (this.amountBalance >= totalPrice) {
			return true;
		}
		return false;
	}
	
	public void setAmountBalance (double totalPrice) {
		this.amountBalance -= totalPrice;
	}

}
