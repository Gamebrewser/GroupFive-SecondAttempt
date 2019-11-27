package mgmt;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

import utilities.DataManager;

/**
 * This class represents Steer Town Auto Parts 
 * @author GroupFive
 * @version 1.0
 */

public final class STAPM implements Serializable {
	private static final long serialVersionUID = 1L;
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<User> users = new ArrayList<User>(); //Stores list of users. (optional)
	private String name;
	private User currentUser; // We will use this for access control


	public STAPM() {
		this.name =  "Steer Town Auto Parts";
		loadItems();
	}

	private void loadItems() {
		ArrayList<String[]> records;
		Item i;		
		try
		{
			records = DataManager.ReadCSV("./data/items.csv",",");
			
	        for(String[] string:records) 
	        {
	        	//1, engine oil, 20, 200, 20100615, toyota, true
	        	i = new Item(string[1], Integer.parseInt(string[2]), Double.parseDouble(string[3]), string[4], Boolean.parseBoolean(string[6]));
	        	//"MM/dd/yyyy";
	        	i.setDate(string[4].substring(4,6) +"/"+ string[4].substring(6)+ "/" +string[4].substring(0,4));
	        	items.add(i);
	        }
		} catch (IOException e) {e.printStackTrace();}
	}

	public String search(String itemName)
	{	String result = "";
		for(Item i:items) {
			if(i.getItemName().contains(itemName)) {
				result+= i.toString() + "\n"; //Because multiple items may have same substring
			}
		}
		if(result.equals("")){
			return "Item not found";
		}
		return result;
	}

	//Items will be sorted in alphabetical order
	public String stockList(){
		Comparator<Item> com = new Comparator<Item>(){
			public int compare(Item item1, Item item2){
				return item1.getItemName().compareTo(item2.getItemName());
			}
		};

		Collections.sort(items,com);

		String result = "";
		for (Item i: items){
			result += i.toString() + "\n";
		}
		return result;
	}

	public static ArrayList<Item> getAllItems(){
		return items;
	}

	//Haven't figured this out yet
	public String genFinReport(User currentUser){
		if (currentUser.getUserType().equals(UserType.Manager)){
			return "You do not have permission to access this feature";
		}
		return "WRITE CODE TO GENERATE REPORT";
	}

	//This may be removed
	public String addUser(User user, String username, String password, UserType userType){
		if(user.getUserType().equals(UserType.Manager)){
			return "You do not have permision to add users";
		}else{
			User newUser = new User(username, password, userType);
			users.add(newUser);
			return "User added successfully.";
		}
	}

	public String removeUser(User user, int idNum){
		if(user.getUserType().equals(UserType.Manager)){
			return "You do not have permission to remove users";
		}else{
			ArrayList<User> toRemove = new ArrayList<User>();
			for(User u: users){
				if( u.getUserID() == idNum){
					toRemove.add(u);
				}
			}
			users.removeAll(toRemove);
			return "User removed successfully";
		}
	}

	public String getName(){
		return name;
	}
	
	//added to check if username and password are correct. - Kyle
	public boolean userValidation(String uname, String pwrd) {
		try 
		{
			ArrayList<String[]> records = DataManager.ReadCSV("./data/credentials.txt");
			for(String[] x : records) {
				 if(x[0].equalsIgnoreCase(uname) && x[1].equalsIgnoreCase(pwrd))
				{
					return true;
				}
			}
		} catch (IOException e) {e.printStackTrace();}
		return false;
	}
}

