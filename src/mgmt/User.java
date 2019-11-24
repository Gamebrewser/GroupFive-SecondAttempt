package mgmt;

/**
 * This class represents an user of the system
 * @@author GroupFive
 * @version 1.0
 */

public class User {
	private String username;
	private String password;
	private UserType userType;
	private static int userID = 0;
	
	public User(String username, String password, UserType userType){
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.userID++; //This will be changed to put the userID in a file.
	}

	public String changeUsername(String oldUserName, String newUserName) {
		if (oldUserName.equals(this.username)){
			this.username = newUserName;
			return "Username changed successfully";
		}else{
			return "Usernames do not match";
		}
	}
	
	public String changePassword(String oldPassword, String newPassword){
		if(oldPassword.equals(this.password)){
			this.password = newPassword;
			return "Password changed successfully";
		}else{
			return "Passwords do not match";
		}
	}

	public UserType getUserType(){
		return userType;
	}

	public int getUserID(){
		return userID;
	}

	public String getUsername(){
		return username;
	}

	//This may or may not be useful
	public String toString(){
		String type="";
		if(getUserType().equals(UserType.Manager)){
			type+="Manager";
		}else{
			type+="Owner";
		}
		
		return ("User ID: " + getUserID() + "Username: " 
		+ getUsername() + "User Type: " + type);
	}

}
