package todo.entity;

import inventory.service.StatementManager;

import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class User {
	private Statement stmt;
	private int userID;
	private String username;
	private String password;
	private Branch branch;
	private Role role;

	public User() {
		stmt = StatementManager.getStatement();
	}

	public User(int userID, String username, String password, Branch branch,
			Role role) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.branch = branch;
		this.role = role;
		stmt = StatementManager.getStatement();
	}

	public int getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		String query = "UPDATE User " + "  SET username = '" + username + "' "
				+ "WHERE userID = '" + userID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String query = "UPDATE User " + "  SET password = '" + password + "' "
				+ "WHERE userID = '" + userID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.password = password;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		String query = "UPDATE User " + "  SET branchID = '"
				+ branch.getBranchID() + "' " + "WHERE userID = '" + userID
				+ "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.branch = branch;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		String query = "UPDATE User " + "  SET roleID = '" + role.getRoleID()
				+ "' " + "WHERE userID = '" + userID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.role = role;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User ID : " + userID + "\n");
		sb.append("Username : " + username + "\n");
		sb.append("Password : " + password + "\n");
		sb.append("Branch : " + branch.toString() + "\n");
		sb.append("Role : " + role.toString() + "\n");
		return sb.toString();
	}

}
