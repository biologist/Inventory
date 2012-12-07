package todo.entity;

import inventory.service.StatementManager;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Type {
	private Statement stmt;
	private int typeID;
	private String typeName;

	public Type() {
		stmt = StatementManager.getStatement();
	}

	public Type(int typeID, String typeName) {
		this.typeID = typeID;
		this.typeName = typeName;
		stmt = StatementManager.getStatement();
	}

	public int getTypeID() {
		return typeID;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		String query = "UPDATE Type " + "  SET typeName = '" + typeName + "' "
				+ "WHERE typeID = '" + typeID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.typeName = typeName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Type ID : " + typeID + "\n");
		sb.append("Type Name : " + typeName + "\n");
		return sb.toString();
	}

}
