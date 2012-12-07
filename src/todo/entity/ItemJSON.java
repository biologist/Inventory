package todo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemJSON {
	private int itemID;
	private String categoryName;
	private String itemName;
	private String size;
	private String description;
	private double price;
	private String image;
	/**
	 * @param itemID
	 * @param categoryName
	 * @param itemName
	 * @param size
	 * @param description
	 * @param price
	 */
	public ItemJSON(int itemID, String categoryName, String itemName,
			String size, String description, double price, String image) {
		super();
		this.itemID = itemID;
		this.categoryName = categoryName;
		this.itemName = itemName;
		this.size = size;
		this.description = description;
		this.price = price;
		this.image = image;
	}
	/**
	 * 
	 */
	public ItemJSON() {
		
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
