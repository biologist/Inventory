package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import todo.entity.User;

import com.mysql.jdbc.Statement;

public class UserDaoList {
	private Statement stmt;
	private List<User> users;
	private static UserDaoList userList;

	private UserDaoList() {
		users = new ArrayList<User>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM User";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				users.add(new User(Integer.parseInt(rs.getString("userID")), rs
						.getString("username"), rs.getString("password"),
						BranchDaoList.getInstance().findByID(
								Integer.parseInt(rs.getString("branchID"))),
						RoleDaoList.getInstance().findByID(
								Integer.parseInt(rs.getString("roleID")))));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create ItemDaoList");
		}
	}

	public static UserDaoList getInstance() {
		if (userList == null)
			userList = new UserDaoList();
		return userList;
	}

	public List<User> findAll() {
		return users;
	}

	public User findByID(int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserID() == id)
				return users.get(i);
		}
		return new User();
	}

	public List<User> findByUsername(String username) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username))
				result.add(users.get(i));
		}
		return result;
	}

	public List<User> findByPassword(String password) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getPassword().equals(password))
				result.add(users.get(i));
		}
		return result;
	}

	public List<User> findByBranchID(int branchID) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getBranch().getBranchID() == branchID)
				result.add(users.get(i));
		}
		return result;
	}

	public List<User> findByRoleID(int roleID) {
		List<User> result = new ArrayList<User>();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getRole().getRoleID() == roleID)
				result.add(users.get(i));
		}
		return result;
	}

	public void createNewUser(String username, String password, int branchID,
			int roleID) {
		String query = "INSERT INTO User VALUES(NULL,'" + username + "','"
				+ password + "','" + branchID + "','" + roleID + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new user into database");
			System.out.println(e);
		}
		users.add(new User(users.size() + 1, username, password, BranchDaoList
				.getInstance().findByID(branchID), RoleDaoList.getInstance()
				.findByID(roleID)));
	}

}
