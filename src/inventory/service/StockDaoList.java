package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.entity.Stock;

import com.mysql.jdbc.Statement;

public class StockDaoList {
	private Statement stmt;
	private List<Stock> stocks;
	private static StockDaoList stockList;

	private StockDaoList() {
		stocks = new ArrayList<Stock>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Stock";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				stocks.add(new Stock(ItemDaoList.getInstance().findByID(
						Integer.parseInt(rs.getString("itemID"))),
						BranchDaoList.getInstance().findByID(
								Integer.parseInt(rs.getString("branchID"))),
						Integer.parseInt(rs.getString("quantity"))));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create StockDaoList");
		}
	}

	public static StockDaoList getInstance() {
		if (stockList == null)
			stockList = new StockDaoList();
		return stockList;
	}

	public List<Stock> findAll() {
		return stocks;
	}

	public List<Stock> findByItemID(int id) {
		List<Stock> result = new ArrayList<Stock>();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getItem().getItemID() == id)
				result.add(stocks.get(i));
		}
		return result;
	}

	public List<Stock> findByBranchID(int id) {
		List<Stock> result = new ArrayList<Stock>();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getBranch().getBranchID() == id)
				result.add(stocks.get(i));
		}
		return result;
	}

	public List<Stock> findByQuantity(int quantity) {
		List<Stock> result = new ArrayList<Stock>();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getQuantity() == quantity)
				result.add(stocks.get(i));
		}
		return result;
	}

	public Stock findByItemIDANDBranchID(int itemID, int branchID) {
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getItem().getItemID() == itemID
					&& stocks.get(i).getBranch().getBranchID() == branchID)
				return stocks.get(i);
		}
		return new Stock();
	}

	public boolean add(int itemID, int branchID, int quantity) {
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getBranch().getBranchID() == branchID
					&& stocks.get(i).getItem().getItemID() == itemID) {
				stocks.get(i).setQuantity(
						stocks.get(i).getQuantity() + quantity);
				return true;
			}
		}
		if (createNewStock(itemID, branchID, quantity))
			return true;
		return false;
	}

	public boolean delete(int itemID, int branchID, int quantity) {
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getBranch().getBranchID() == branchID
					&& stocks.get(i).getItem().getItemID() == itemID) {
				if (stocks.get(i).getQuantity() > quantity) {
					int newQuantity = stocks.get(i).getQuantity() - quantity;
					String query = "UPDATE Stock " + "  SET quantity = '"
							+ newQuantity + "' " + "WHERE itemID = '" + itemID
							+ "' AND branchID = '" + branchID + "'";
					try {
						stmt.executeUpdate(query);
					} catch (SQLException e) {
						System.out.println("Cannot query");
						e.printStackTrace();
						return false;
					}
					stocks.get(i).setQuantity(
							stocks.get(i).getQuantity() - quantity);
					return true;
				}

				if (stocks.get(i).getQuantity() == quantity) {
					String query = "DELETE FROM Stock WHERE itemID = '"
							+ itemID + "' AND branchID = '" + branchID + "'";
					try {
						stmt.executeUpdate(query);
					} catch (SQLException e) {
						System.out.println("Cannot query");
						e.printStackTrace();
						return false;
					}
					stocks.remove(i);
					return true;
				}

				if (stocks.get(i).getQuantity() < quantity) {
					System.out.println("Quantity is not enought to delete");
					return false;
				}
			}
		}
		return false;
	}

	private boolean createNewStock(int itemID, int branchID, int quantity) {
		String query = "INSERT INTO Stock VALUES('" + itemID + "','" + branchID
				+ "','" + quantity + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new stock into database");
			System.out.println(e);
			return false;
		}
		stocks.add(new Stock(ItemDaoList.getInstance().findByID(itemID),
				BranchDaoList.getInstance().findByID(branchID), quantity));
		return true;
	}

}
