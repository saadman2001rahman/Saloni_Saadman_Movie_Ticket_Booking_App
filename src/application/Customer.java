package application;

public class Customer extends User {
    private double amountBalance;

    /**
     * Create a customer(sub class of User) with a unique id (username), name, age and an amountBalance set by admin
     * @param id
     * @param name
     * @param age
     * @param amountBalance
     */
    public Customer(String id, String name, int age, double amountBalance) {
        super(id, name, age);
        this.amountBalance = amountBalance;
    }

    /**
     * 
     * @return customer amountBalance
     */
    public double getAmountBalance(){
        return this.amountBalance;
    }

    /**
     * Check if the customer has enough balance in their account
     * @param totalPrice
     * @return Boolean
     */
    public boolean hasEnoughBalance(double totalPrice) {
        if(this.amountBalance >= totalPrice){
            return true;
        }
        return false;
    }

    /**
     * Update customers amount with the totalPrice of the selected movie by deducting the totalPrice amount
     * @param totalPrice
     */
    public void setAmountBalance(double totalPrice) {
        this.amountBalance -= totalPrice;
    }

}
