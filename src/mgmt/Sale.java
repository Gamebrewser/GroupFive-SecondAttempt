package mgmt;

import java.util.*;
import java.io.*;

public class Sale {
	private Date date;
	private double total;
	private String itemsBought = "";
	private ArrayList<SaleItem> cart = new ArrayList<SaleItem>();

	
	public void addItem(SaleItem saleItem){
		cart.add(saleItem);
	}

	//If a customer no longer wants an item, ensure to add back the quantity
	public void removeItem(SaleItem saleItem){
		
	}

	//Revise this
	public void checkout(){
		double total = 0.0;

		for(SaleItem saleItem: cart){
			total += (saleItem.getPrice() * qtyBought);
		}

		//Create receipt object, then call print function on receipt obj
	}

	public void processSale() {
	
	}
}
