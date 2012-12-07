package todo.entity;

import inventory.service.StatementManager;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Role {
	private Statement stmt;
	private int roleID;
	private String roleName;

	public Role() {
		stmt = StatementManager.getStatement();
	}

	public Role(int roleID, String roleName) {
		this.roleID = roleID;
		this.roleName = roleName;
		stmt = StatementManager.getStatement();
	}

	public int getRoleID() {
		return roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		String query = "UPDATE Role " + "  SET roleName = '" + roleName + "' "
				+ "WHERE roleID = '" + roleID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.roleName = roleName;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Role ID : " + roleID + "\n");
		sb.append("Role Name : " + roleName + "\n");
		return sb.toString();
	}

}
