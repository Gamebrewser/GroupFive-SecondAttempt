package mgmt;

public class SaleItem {
	public int quantitySold;
	public String Name;
	public double subTotal;
	


	public void decreaseStock(Item e, int amt) {
		int quantityInStock = e.getQuantityInStock()-amt;
		e.setQuantityInStock(quantityInStock);
		}
}
