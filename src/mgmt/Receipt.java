package mgmt;

import java.text.SimpleDateFormat;
import java.util.*;


public class Receipt {
    public String time;
    public String itemsBought;
    public double totalCost;

    public Receipt(String itemsBought, double totalCost){
        this.itemsBought = itemsBought;
        this.totalCost = totalCost;
        
        
    }

    public String print(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        time = formatter.format(calendar.getTime());
        return "------- Steer Town Auto Parts -------\n" +
                "------- " + time + " ------- \n" + 
                "------- " + itemsBought + " ------- \n" +
                "Total Cost: $" + totalCost;
    }
}
