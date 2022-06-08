package com.miola.complexeMedicale.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.miola.complexeMedicale.connection.DbCon;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DeletePatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con;
		int id = Integer.parseInt(request.getParameter("id"));
		boolean rowDeleted;
		try {
			con=DbCon.getConnection();
			PreparedStatement statement = con.prepareStatement("delete from patient where id=?") ;
				statement.setInt(1, id);
				rowDeleted = statement.executeUpdate() > 0;
				
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		 //request.getRequestDispatcher("/DoctorsCrud1jsp.jsp").forward(request, response);
		response.sendRedirect("patientsCrud.jsp");
		
	
	}

}
