package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import todo.entity.Role;

import com.mysql.jdbc.Statement;

public class RoleDaoList {
	private Statement stmt;
	private List<Role> roles;
	private static RoleDaoList roleList;

	private RoleDaoList() {
		roles = new ArrayList<Role>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Role";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				roles.add(new Role(Integer.parseInt(rs.getString("roleID")), rs
						.getString("roleName")));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create ItemDaoList");
		}
	}

	public static RoleDaoList getInstance() {
		if (roleList == null)
			roleList = new RoleDaoList();
		return roleList;
	}

	public List<Role> findAll() {
		return roles;
	}

	public Role findByID(int id) {
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).getRoleID() == id)
				return roles.get(i);
		}
		return new Role();
	}

	public List<Role> findByName(String name) {
		List<Role> result = new ArrayList<Role>();
		for (int i = 0; i < roles.size(); i++) {
			if (roles.get(i).getRoleName().equals(name))
				result.add(roles.get(i));
		}
		return result;
	}

	public void createNewRole(String roleName) {
		String query = "INSERT INTO Role VALUES(NULL,'" + roleName + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new role into database");
			System.out.println(e);
		}
		roles.add(new Role(roles.size() + 1, roleName));
	}
}
