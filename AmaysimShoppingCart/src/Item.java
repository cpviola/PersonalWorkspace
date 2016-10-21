/**
 * 
 */

/**
 * @author cpviola
 *
 */
public class Item {

	/**
	 * 
	 */
	
	private String itemCode;
	private String itemName;
	private double itemPrice;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String itemName, double itemPrice) {
		// TODO Auto-generated constructor stub
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public Item(String itemCode, String itemName, double itemPrice) {
		// TODO Auto-generated constructor stub
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

}
