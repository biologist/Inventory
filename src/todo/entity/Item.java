package todo.entity;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import com.mysql.jdbc.Statement;
import inventory.service.CategoryDaoList;
import inventory.service.StatementManager;

@XmlRootElement
public class Item {
	private Statement stmt;
	private int itemID;
	private Category category;
	private String itemName;
	private String size;
	private String description;

	private double price;

	public Item() {
		stmt = StatementManager.getStatement();
	}

	public Item(int itemID, Category category, String itemName, String size,
			String description, double price) {
		this.itemID = itemID;
		this.category = category;
		this.itemName = itemName;
		this.size = size;
		this.description = description;
		this.price = price;
		stmt = StatementManager.getStatement();
	}

	public void setCategoryID(int categoryID) {
		String query = "UPDATE Item " + "  SET categoryID = '" + categoryID
				+ "' " + "WHERE itemID = '" + itemID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.category = CategoryDaoList.getInstance().findByID(categoryID);
	}

	public void setItemName(String itemName) {
		String query = "UPDATE Item " + "  SET itemName = '" + itemName + "' "
				+ "WHERE itemID = '" + itemID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.itemName = itemName;
	}

	public void setSize(String size) {
		String query = "UPDATE Item " + "  SET size = '" + size + "' "
				+ "WHERE itemID = '" + itemID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.size = size;
	}

	public void setDescription(String description) {
		String query = "UPDATE Item " + "  SET description = '" + description
				+ "' " + "WHERE itemID = '" + itemID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.description = description;
	}

	public void setPrice(double price) {
		String query = "UPDATE Item " + "  SET price = '" + price + "' "
				+ "WHERE itemID = '" + itemID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.price = price;
	}

	public int getItemID() {
		return itemID;
	}

	public Category getCategory() {
		return category;
	}



	public String getItemName() {
		return itemName;
	}

	public String getSize() {
		return size;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Item ID : " + itemID + "\n");
		sb.append("Category : " + category.toString() + "\n");
		sb.append("Item Name : " + itemName + "\n");
		sb.append("Size : " + size + "\n");
		sb.append("Description : " + description + "\n");
		sb.append("Price : " + price + "\n");
		return sb.toString();
	}

}
