package inventory.service;

import java.sql.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class StatementManager {
	private static Connection co;

	private static void initConnection() {
		if (co == null) {
			co = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				co = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/Inventory?user=root&charactorEncoding=utf8");
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static Statement getStatement() {
		initConnection();
		try {
			return (Statement) co.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
