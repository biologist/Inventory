package todo.entity;

import inventory.service.StatementManager;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Category {
	private Statement stmt;
	private int categoryID;
	private String categoryName;

	public Category() {
		stmt = StatementManager.getStatement();
	}

	public Category(int categoryID, String categoryName) {
		stmt = StatementManager.getStatement();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public void setCategoryName(String categoryName) {
		String query = "UPDATE Category " + "  SET categoryName = '"
				+ categoryName + "' " + "WHERE categoryID = '" + categoryID
				+ "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.categoryName = categoryName;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Category ID : " + categoryID + "\n");
		sb.append("Category Name : " + categoryName + "\n");
		return sb.toString();
	}

}
