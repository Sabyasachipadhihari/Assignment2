package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.dbconn.DatabaseConnection;

//@WebServlet("/insertData")
public class InsertControllers extends HttpServlet

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();


		DatabaseConnection dbcon = new DatabaseConnection();
		

		try {
			dbcon.getConn();
			PreparedStatement statement = dbcon.connection
					.prepareStatement("insert into emp values(?,?,?,?,?)");
			statement.setInt(1, Integer.parseInt(request.getParameter("id")));
			statement.setString(2, request.getParameter("name"));
			statement.setString(3, request.getParameter("desc"));
			statement.setDouble(4, Double.parseDouble(request.getParameter("sal")));
			statement.setInt(5, Integer.parseInt(request.getParameter("age")));
			int x = statement.executeUpdate();
			System.out.println(x);
			if (x != 0) {
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				out.println("<b><h4 style='color:green;'>data Inserted successfully</h4></b>");

			} else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				out.println("<b><p style='color:red;'>data insertion failed !!!!</p></b>");
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
