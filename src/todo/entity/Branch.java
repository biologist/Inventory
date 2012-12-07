package todo.entity;

import java.sql.SQLException;

import javax.xml.bind.annotation.XmlRootElement;

import inventory.service.StatementManager;

import com.mysql.jdbc.Statement;

@XmlRootElement
public class Branch {
	private Statement stmt;

	private int branchID;

	private String branchName;

	private String location;

	private String telephone;

	public Branch() {
		stmt = StatementManager.getStatement();
	}

	public Branch(int branchID, String branchName, String location,
			String telephone) {
		this.branchID = branchID;
		this.branchName = branchName;
		this.location = location;
		this.telephone = telephone;
		stmt = StatementManager.getStatement();
	}

	public void setBranchName(String branchName) {
		String query = "UPDATE Branch " + "  SET branchName = '" + branchName
				+ "' " + "WHERE branchID = '" + branchID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.branchName = branchName;
	}

	public void setLocation(String location) {
		String query = "UPDATE Branch " + "  SET location = '" + location
				+ "' " + "WHERE branchID = '" + branchID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.location = location;
	}

	public void setTelephone(String telephone) {
		String query = "UPDATE Branch " + "  SET telephone = '" + telephone
				+ "' " + "WHERE branchID = '" + branchID + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Cannot query");
			e.printStackTrace();
		}
		this.telephone = telephone;
	}

	public int getBranchID() {
		return branchID;
	}

	public String getBranchName() {
		return branchName;
	}

	public String getLocation() {
		return location;
	}

	public String getTelephone() {
		return telephone;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Branch ID : " + branchID + "\n");
		sb.append("Branch Name : " + branchName + "\n");
		sb.append("Location : " + location + "\n");
		sb.append("Telephone : " + telephone + "\n");
		return sb.toString();
	}

}
