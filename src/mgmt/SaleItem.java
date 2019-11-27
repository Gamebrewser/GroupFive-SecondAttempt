package mgmt;

import java.util.*;

public class SaleItem {
	public int quantitySold;
	public String name;
	public double price;
	public int itemID;

	public SaleItem(int itemID, String name, int quantitySold, double price){
		this.itemID = itemID;
		this.name = name;
		this.quantitySold = quantitySold;
		this.price = price;
	}

	// If this returns false, bring up stock low error message
	public boolean decreaseStock(int itemID, int qty) {
		ArrayList<Item> items = STAPM.getAllItems();
		int quantityInStock = 6; //This will be changed

		for(Item i: items){
			if(i.getItemID() == itemID){
				quantityInStock = i.getQuantityInStock()-qty;
				i.setQuantityInStock(quantityInStock);
				break;
			}
		}

		if (quantityInStock <= 5){
			return false;
		}
		return true;
		}

	public void increaseStock(int itemID, int qty) {
		ArrayList<Item> items = STAPM.getAllItems();

		for(Item i: items){
			if(i.getItemID() == itemID){
				i.setQuantityInStock(i.getQuantityInStock()+ qty);
				break;
			}
		}
	}

	//Complete this
	public String toString(){
		return (" ID: " + this.itemID + "Name: " + this.name + "Qty Bought: " + this.quantitySold + "Price per Unit: $" + this.price
		+ "Cum. Price: $" + (quantitySold * this.price) + "\n");
	}
}
