package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import todo.entity.Item;

public class ItemDaoList {
	private Statement stmt;
	private List<Item> items;
	private static ItemDaoList itemList;

	private ItemDaoList() {
		items = new ArrayList<Item>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Item";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				items.add(new Item(Integer.parseInt(rs.getString("itemID")),
						CategoryDaoList.getInstance().findByID(
								Integer.parseInt(rs.getString("categoryID"))),
						rs.getString("itemName"), rs.getString("size"), rs
								.getString("description"), Double
								.parseDouble(rs.getString("price"))));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create ItemDaoList");
		}
	}

	public static ItemDaoList getInstance() {
		if (itemList == null)
			itemList = new ItemDaoList();
		return itemList;
	}

	public List<Item> findAll() {
		return items;
	}

	public Item findByID(int id) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemID() == id)
				return items.get(i);
		}
		return new Item();
	}

	public List<Item> findByCategoryID(int categoryID) {
		List<Item> result = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getCategory().getCategoryID() == categoryID)
				result.add(items.get(i));
		}
		return result;
	}

	public List<Item> findByName(String name) {
		List<Item> result = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getItemName().equals(name))
				result.add(items.get(i));
		}
		return result;
	}

	public List<Item> findBySize(String size) {
		List<Item> result = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getSize().equals(size))
				result.add(items.get(i));
		}
		return result;
	}

	public List<Item> findByTelephone(String description) {
		List<Item> result = new ArrayList<Item>();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getDescription().equals(description))
				result.add(items.get(i));
		}
		return result;
	}

	public Item findByPrice(double d) {
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getPrice() == d)
				return items.get(i);
		}
		return null;
	}

	public void createNewItem(int categoryID, String itemName, String size,
			String description, double price) {
		String query = "INSERT INTO Item VALUES(NULL,'" + categoryID + "','"
				+ itemName + "','" + size + "','" + description + "','" + price
				+ "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new item into database");
			System.out.println(e);
		}
		items.add(new Item(items.size() + 1, CategoryDaoList.getInstance()
				.findByID(categoryID), itemName, size, description, price));
	}
}
