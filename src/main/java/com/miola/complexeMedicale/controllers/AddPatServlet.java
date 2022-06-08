package com.miola.complexeMedicale.controllers;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.miola.complexeMedicale.models.*;
import com.miola.complexeMedicale.connection.*;
import jakarta.servlet.RequestDispatcher;


public class AddPatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	
    	RequestDispatcher dispatcher = null;

		try {
			Connection con = DbCon.getConnection();
			
			String nom= request.getParameter("nom");
			String prenom= request.getParameter("prenom");
			String tel= request.getParameter("tel");
			String email= request.getParameter("email");
			String password= request.getParameter("password");
			String username = request.getParameter("username");
			

			
			
			
			  PreparedStatement preparedStatement = con.prepareStatement("insert into patient(username,nom,prenom,tel,email,password) values (?,?,?,?,?,?)");
			  preparedStatement.setString(1,username);
			  preparedStatement.setString(2,nom);
			  preparedStatement.setString(3,prenom);
			  preparedStatement.setString(4,tel);
			  preparedStatement.setString(5,email);
			  preparedStatement.setString(6,password);
			 

		
			 int row= preparedStatement.executeUpdate();
			 if(row>0) {
				 System.out.println("okkk");
			 }else {
				 System.out.println("laaaa");
			 }
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//request.getRequestDispatcher("/DoctorsCrud1jsp.jsp");
		response.sendRedirect("patientsCrud.jsp");
		
    	
    	
    	
	}

}
