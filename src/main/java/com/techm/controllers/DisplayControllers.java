package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.dbconn.DatabaseConnection;

public class DisplayControllers extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatabaseConnection dbcon = new DatabaseConnection();
		dbcon.getConn();
		Statement stmnt = null;
		ResultSet rs = null;
		String query1 = "select * from emp";
		String table = "<div style='text-align: center; '>" + "<table border=3>"

				+ "<tr>" + "<th>Id</th>" + "<th>Name</th>" + "<th>Designation</th>" + "<th>Salary</th>" + "<th>Age</th>"
				+ "</tr>";
		try {
			stmnt = dbcon.connection.createStatement();
			rs = stmnt.executeQuery(query1);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String desc = rs.getString("des");
				double sal = rs.getDouble("sal");
				int age = rs.getInt("age");

				table = table + "<tr>" + "<td>" + id + "</td>" + "<td>" + name + "</td>" + "<td>" + desc + "</td>"
						+ "<td>" + sal + "</td>" + "<td>" + age + "</td>" + "</tr>";
			}

			table = table + "</table> " + "</div>"+"<h4><a href='index.jsp' style='text-decoration: none;'>Home Page</a></h4>";

			out.print(table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
