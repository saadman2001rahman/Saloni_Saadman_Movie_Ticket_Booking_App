package application;

public class User {
	private int userID;
	private String userName= "";
	private int age;
	
	public User(int uID, String uName, int uAge) {
		this.userID = uID;
		this.userName = uName;
		this.age = uAge;
	}
	

	public String getName() {
		return this.userName;
	}

}
