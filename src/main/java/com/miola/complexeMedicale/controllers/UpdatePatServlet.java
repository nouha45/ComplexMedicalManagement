package com.miola.complexeMedicale.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.miola.complexeMedicale.connection.DbCon;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UpdatePatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  System.out.println("Ana f update");
			Connection con;
			 
			
			
			int id = Integer.parseInt(request.getParameter("id"));
			    String username= request.getParameter("username");
	            String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String tel= request.getParameter("tel");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				
				
				 boolean rowUpdated=false;
				  try {
					  con=DbCon.getConnection();
					 
					  PreparedStatement preparedStatement = con.prepareStatement("update patient set username=? ,nom=?,prenom=?,tel=?,email=?,password=? where id=?");
					  preparedStatement.setString(1, username);
					  preparedStatement.setString(2, nom);
					  preparedStatement.setString(3, prenom);
					  preparedStatement.setString(4, tel);
					  preparedStatement.setString(5, email);
					  preparedStatement.setString(6, password);
					  
					  preparedStatement.setInt(8,id);
					  System.out.println("l'erreur dial null mchat");
					  
					  
					  rowUpdated = preparedStatement.executeUpdate()>0;
					  
					  if(rowUpdated) {
						  System.out.println("ndaaaa");
					  }
					  else {
						 System.out.println("9lbi 3la l'erreur a benty");}
					  
				  }catch(SQLException |ClassNotFoundException e) {
					  e.printStackTrace();
				  }
				  //request.getRequestDispatcher("/DoctorsCrud1jsp.jsp");
				  response.sendRedirect("patientsCrud.jsp");
	}

}
