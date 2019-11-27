package mgmt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

/**
 * This class will be used to manipulate items in stock
 * @author GroupFive
 * @version 1.0
 * 
 */

public class Stock {
	public String name;
	public double costPricePerUnit;
	public  Date date; //needs a type for date
	public boolean returnable;
	private ArrayList<Item> items;

	public Stock(){
		items = STAPM.getAllItems();
	}

	public void addStock(String name, int quantity, double price,String manufacturer, 
			boolean taxable, String date){
		Item stockItem = new Item(name,quantity,price,manufacturer, taxable);
		stockItem.setDate(date);
		this.items.add(stockItem);
	}

	public boolean removeStockItem(int itemId){
		ArrayList<Item> toRemove = new ArrayList<Item>();
		for(Item i: items){
			if( i.getItemID() == itemId){
				toRemove.add(i);
			}
		}

		if(toRemove.isEmpty()){
			return false; // Incase you try delete an item not on the list
		}else{
			items.removeAll(toRemove);
			return true;
		}
	}

	//User must increase or decrease item based on ID
	public String increaseStockItem(int itemID, int qtyAdded){
		//add the parameter given
		int qtyToAdd;
		for(Item i: items){
			if(i.getItemID() == itemID){
				qtyToAdd=(i.getQuantityInStock()) + qtyAdded;
				i.setQuantityInStock(qtyToAdd);
				return "Quantity update successful";
			}
		}
		return "Quantity update unsucessful";
	}

	
	public String decreaseStockItem(int itemID, int qtyDecreased){
		//subtract the parameter given
		int qtyToDecrease;
		for(Item i: items){
			if(i.getItemID() == itemID){
				qtyToDecrease=(i.getQuantityInStock()) - qtyDecreased;
				i.setQuantityInStock(qtyToDecrease);
				return "Quantity update successful";
			}
		}
		return "Quantity update unsucessful";
	}
}