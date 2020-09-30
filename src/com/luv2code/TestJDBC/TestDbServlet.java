package com.luv2code.TestJDBC;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String user="springstudent";
			String pass="springstudent";
 		
			String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
			String driver = "com.mysql.cj.jdbc.Driver";
			
			try {
				PrintWriter out=resp.getWriter();
				out.println("Connecting to database : "+jdbcUrl);
				Class.forName(driver);
				
				Connection myCon=DriverManager.getConnection(jdbcUrl,user,pass);
				out.println("Success !!! ");
				myCon.close();
				
			}catch(Exception exp) {
				exp.printStackTrace();
				throw new ServletException();
			}
	}

	

}
