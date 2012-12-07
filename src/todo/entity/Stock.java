package todo.entity;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import inventory.service.StatementManager;

import com.mysql.jdbc.Statement;

@XmlRootElement
public class Stock {
	private Statement stmt;
	private Item item;
	private Branch branch;
	private int quantity;


	public Stock() {
		stmt = StatementManager.getStatement();
	}

	public Stock(Item item, Branch branch, int quantity) {
		this.item = item;
		this.branch = branch;
		this.quantity = quantity;
		stmt = StatementManager.getStatement();
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		String query = "UPDATE Stock " + "  SET itemID = '" + item.getItemID()
				+ "' " + "WHERE branchID = '" + branch.getBranchID()
				+ "' AND quantity = '" + quantity + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.item = item;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		String query = "UPDATE Stock " + "  SET branchID = '"
				+ branch.getBranchID() + "' " + "WHERE itemID = '"
				+ item.getItemID() + "' AND quantity = '" + quantity + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.branch = branch;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		String query = "UPDATE Stock " + "  SET quantity = '" + quantity + "' "
				+ "WHERE itemID = '" + item.getItemID() + "' AND branchID = '"
				+ branch.getBranchID() + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.quantity = quantity;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(item.toString() + "\n");
		sb.append(branch.toString() + "\n");
		sb.append("Quantity : " + quantity + "\n");
		return sb.toString();
	}

}
