package inventory.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import todo.entity.Branch;

public class BranchDaoList {
	private Statement stmt;
	private List<Branch> branchs;
	private static BranchDaoList branchList;

	private BranchDaoList() {
		branchs = new ArrayList<Branch>();
		try {
			stmt = StatementManager.getStatement();
			String query = "SELECT * FROM Branch";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				branchs.add(new Branch(Integer.parseInt(rs
						.getString("branchID")), rs.getString("branchName"), rs
						.getString("location"), rs.getString("telephone")));
			}
		} catch (SQLException e) {
			System.out.println("Cannot create BranchDaoList");
		}
	}

	public static BranchDaoList getInstance() {
		if (branchList == null)
			branchList = new BranchDaoList();
		return branchList;
	}

	public List<Branch> findAll() {
		return branchs;
	}

	public Branch findByID(int id) {
		for (int i = 0; i < branchs.size(); i++) {
			if (branchs.get(i).getBranchID() == id)
				return branchs.get(i);
		}
		return new Branch();
	}

	public List<Branch> findByName(String name) {
		List<Branch> result = new ArrayList<Branch>();
		for (int i = 0; i < branchs.size(); i++) {
			if (branchs.get(i).getBranchName().equals(name))
				result.add(branchs.get(i));
		}
		return result;
	}

	public List<Branch> findByLocation(String location) {
		List<Branch> result = new ArrayList<Branch>();
		for (int i = 0; i < branchs.size(); i++) {
			if (branchs.get(i).getLocation().equals(location))
				result.add(branchs.get(i));
		}
		return result;
	}

	public List<Branch> findByTelephone(String telephone) {
		List<Branch> result = new ArrayList<Branch>();
		for (int i = 0; i < branchs.size(); i++) {
			if (branchs.get(i).getTelephone().equals(telephone))
				result.add(branchs.get(i));
		}
		return result;
	}

	public void createNewBranch(String branchName, String location,
			String telephone) {
		String query = "INSERT INTO Branch VALUES(NULL,'" + branchName + "','"
				+ location + "','" + telephone + "')";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot insert new branch into database");
			System.out.println(e);
		}
		branchs.add(new Branch(branchs.size() + 1, branchName, location,
				telephone));
	}
}
