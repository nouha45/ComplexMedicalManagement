package com.miola.complexeMedicale.controllers;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class NavigationServlet
 */

public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		 RequestDispatcher dispatcher = null;
		
		if(action.equals("visits")) {
			response.sendRedirect("dashboardAdmin.jsp");
			
		}
		
		else if(action.equals("CrudDoctors")) {
			//dispatcher = (RequestDispatcher) request.getRequestDispatcher("DoctorsCrud1jsp.jsp");
			response.sendRedirect("DoctorsCrud1jsp.jsp");
		
			
		}
		else {
			//dispatcher = (RequestDispatcher) request.getRequestDispatcher("PatientsCrud.jsp");
			response.sendRedirect("patientsCrud.jsp");
		}
		
	}
	
	
	
	
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
