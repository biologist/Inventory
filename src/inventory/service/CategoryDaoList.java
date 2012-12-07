package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.entity.Category;

import com.mysql.jdbc.Statement;

public class CategoryDaoList {
	private Statement stmt;
	private List<Category> categorys;
	private static CategoryDaoList categoryList;

	private CategoryDaoList() {
		categorys = new ArrayList<Category>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Category";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				categorys
						.add(new Category(Integer.parseInt(rs
								.getString("categoryID")), rs
								.getString("categoryName")));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create CategoryDaoList");
		}
	}

	public static CategoryDaoList getInstance() {
		if (categoryList == null)
			categoryList = new CategoryDaoList();
		return categoryList;
	}

	public List<Category> findAll() {
		return categorys;
	}

	public Category findByID(int id) {
		for (int i = 0; i < categorys.size(); i++) {
			if (categorys.get(i).getCategoryID() == id)
				return categorys.get(i);
		}
		return new Category();
	}

	public Category findByName(String name) {
		for (int i = 0; i < categorys.size(); i++) {
			if (categorys.get(i).getCategoryName().equals(name))
				return categorys.get(i);
		}
		return new Category();
	}

	public void createNewCategory(String categoryName) {
		String query = "INSERT INTO Category VALUES(NULL,'" + categoryName
				+ "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new category into database");
			System.out.println(e);
		}
		categorys.add(new Category(categorys.size() + 1, categoryName));
	}
}
