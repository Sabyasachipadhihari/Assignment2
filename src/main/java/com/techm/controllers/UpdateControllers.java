package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.dbconn.DatabaseConnection;

public class UpdateControllers extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatabaseConnection dbcon = new DatabaseConnection();
		dbcon.getConn();
		PreparedStatement statement;
		try {
			statement = dbcon.connection.prepareStatement("UPDATE emp SET sal =? WHERE id=?;");
			statement.setDouble(1, Double.parseDouble(request.getParameter("sal")));
			statement.setInt(2, Integer.parseInt(request.getParameter("id")));
			
			int x = statement.executeUpdate();
			if (x != 0) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
