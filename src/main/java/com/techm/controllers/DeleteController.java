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

public class DeleteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		DatabaseConnection dbcon = new DatabaseConnection();
		try {
			dbcon.getConn();
			PreparedStatement statement = dbcon.connection
					.prepareStatement("DELETE FROM emp WHERE id=?;");
			statement.setInt(1, Integer.parseInt(request.getParameter("id")));
		
			int x = statement.executeUpdate();
			System.out.println(x);
			if (x != 0) {
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
