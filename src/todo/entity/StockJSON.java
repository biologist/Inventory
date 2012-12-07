package todo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StockJSON {
	private int quantity;
	private int itemID;
	private int branchID;
	/**
	 * 
	 */
	public StockJSON() {
		
	}
	@Override
	public String toString() {
		return "StockJSON [quantity=" + quantity + ", itemID=" + itemID
				+ ", branchID=" + branchID + "]";
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getBranchID() {
		return branchID;
	}
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}
	/**
	 * @param quantity
	 * @param itemID
	 * @param branchID
	 */
	public StockJSON(int quantity, int itemID, int branchID) {
		super();
		this.quantity = quantity;
		this.itemID = itemID;
		this.branchID = branchID;
	}
}
