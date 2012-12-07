package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.entity.Type;

import com.mysql.jdbc.Statement;

public class TypeDaoList {
	private Statement stmt;
	private List<Type> types;
	private static TypeDaoList typeList;

	private TypeDaoList() {
		types = new ArrayList<Type>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Type";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				types.add(new Type(Integer.parseInt(rs.getString("typeID")), rs
						.getString("username")));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create TypeDaoList");
		}
	}
}
