package com.techm.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public Connection connection ;

	public void getConn() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demos?user=root&password=root");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
