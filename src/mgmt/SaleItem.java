package mgmt;

public class SaleItem {
	public int quantitySold;
	public String Name;
	public double subTotal;

	// If this returns false, bring up stock low error message
	public boolean decreaseStock(Item e, int amt) {
		int quantityInStock = e.getQuantityInStock()-amt;
		e.setQuantityInStock(quantityInStock);
		if (quantityInStock <= 5){
			return false;
		}
		return true;
		}
}
