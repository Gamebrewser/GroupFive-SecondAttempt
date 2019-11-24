package mgmt;

import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private String itemName;
	private int quantityInStock;
	private double price;
	private String manufacturer;
	private boolean taxable;
	private Date dateAdded;
	private static int itemID = 0;
	//private double taxRate; put in Sale so that everything gets taxed.
	
	public Item(String name, int qty, double price, String manufacturer, boolean taxable)
	{
		this.itemName = name;
		this.quantityInStock = qty;
		this.price=price;
		this.manufacturer=manufacturer;
		this.taxable=taxable;
		this.itemID++;
	}

	public Item(String name, int qty, double price, String manufacturer, boolean taxable, Date date)
	{
		this.itemName = name;
		this.quantityInStock = qty;
		this.price=price;
		this.manufacturer=manufacturer;
		this.taxable=taxable;
		this.dateAdded = date;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}
	
	//Lets take this out, I will explain it to you
	/*
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	*/

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//I think java has a way to get the date from the computer..... we 
	//should look into this
	public void setDate(String date) {
	    String expectedPattern = "MM/dd/yyyy";
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
	    try
	    {
	      String userInput = "09/22/2009";
	      this.dateAdded = formatter.parse(userInput);
	    }
	    catch (ParseException e)
	    {
	      e.printStackTrace();
	    }
	}

	public int getItemID(){
		return this.itemID;
	}

	//Suppose the man want change his prices?
	public void changePrice(double newPrice){
		this.price = newPrice;
	}

	public String toString(){
		return (" ID: " + getItemID() + "Name: " + getItemName() + "Manufacturer: " + manufacturer
		+ "Price: $" + getPrice() + "Qty in Stock: " + getQuantityInStock() );
	}
	
	
}



