package db;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.testng.annotations.Test;

public class Connectdatabase {

	Connection con = null;
	List<User> userList = new ArrayList<>();

	public void testDB() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver Loaded");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mes", "root", "root");

		System.out.println("Connected to Mysql");

		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from meslogin");

		while (rs.next()) {
			String username = rs.getString("Username");
			System.out.println("Database record is " + username);
			String password = rs.getString("Password");
			System.out.println("Database record is " + password);

			userList.add(new User(username, password));
		}

	}

	public List<User> getUserList() {

		return userList;
	}

}
