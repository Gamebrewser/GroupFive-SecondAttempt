package mgmt;

import java.util.*;
import java.io.*;

public class Sale {
	private double total;
	private String itemsBought = "";
	private ArrayList<SaleItem> cart = new ArrayList<SaleItem>();
	private ArrayList<Item> items;
	private File totalIncomeFile = new File("./data/totalIncome.txt");
	private double totalIncome;

	public Sale(){
		items = STAPM.getAllItems();
	}

	public void addItem(int itemId, int qty){
		boolean alert= true;
		for(Item item: items){
			if(item.getItemID() == itemId){
				//Create SaleItem object and add to cart
				SaleItem saleItemObj = new SaleItem(itemId, item.getItemName(), qty, item.getPrice());
				alert = saleItemObj.decreaseStock(itemId, qty);
				cart.add(saleItemObj);
				break;
			}
		}
		if(alert == false){
			//Print alert message
		}

	}

	//If a customer no longer wants an item, ensure to add back the quantity
	public void removeItem(int itemId){
		ArrayList<SaleItem> toRemove = new ArrayList<SaleItem>();
		for(SaleItem saleItem: cart){
			if(saleItem.itemID ==itemId){
				saleItem.increaseStock(itemId, saleItem.quantitySold);
				toRemove.add(saleItem);
				break;
			}
		}
		cart.removeAll(toRemove);

	}

	public void removeAllItems(){
		cart.clear();
	}

	//Revise this
	public void checkout(){

		for(SaleItem saleItem: cart){
			itemsBought += saleItem.toString();
			total += (saleItem.price * saleItem.quantitySold);
		}

		try{
            if (totalIncomeFile.exists()){
                FileReader file=new FileReader(totalIncomeFile);
                BufferedReader br=new BufferedReader(file);
                String value=br.readLine();
                totalIncome=Double.parseDouble(value);
                
				totalIncomeFile.delete();
				br.close();

            }else{
                totalIncome=0.0;
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
		}
		
		totalIncome += total;

		try{
            PrintWriter writer=new PrintWriter(totalIncomeFile);
            totalIncomeFile.createNewFile();
            writer.write(String.valueOf(totalIncome));
            writer.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
		}

		//Create receipt object, then call print function on receipt obj
		Receipt receiptObj = new Receipt(itemsBought, total);

		//This is the customer's receipt
		String customerReceitpt = receiptObj.print();


	}

}
