package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import todo.entity.Stock;

import com.mysql.jdbc.Statement;

public class MyBean {
	private Stock store;
	private Statement stmt;

	public MyBean() {
		stmt = StatementManager.getStatement();

	}

	public void generateStore() {
		store = new Stock();
		String query = "SELECT * FROM Item, Store, Branch WHERE Item.item_id = Store.item_id AND Branch.branch_id = Store.branch_id";
		try {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Stock getStore() {
		return store;
	}

	public String showMsg() {
		return "Show message !!!";
	}
}
