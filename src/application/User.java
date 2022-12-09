package application;

public class User {
	private String userID;
	private String userName= "";
	private int age;
	
	/**
	 * Construct User with a unique user ID, name and age
	 * @param uID
	 * @param uName
	 * @param uAge
	 */
	public User(String uID, String uName, int uAge) {
		this.userID = uID;
		this.userName = uName;
		this.age = uAge;
	}
	

	public String getName() {
		return this.userName;
	}

}
