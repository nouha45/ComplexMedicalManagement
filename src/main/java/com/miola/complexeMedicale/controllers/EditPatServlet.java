package com.miola.complexeMedicale.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.miola.complexeMedicale.connection.DbCon;
import com.miola.complexeMedicale.models.Doctor;
import com.miola.complexeMedicale.models.Patient;


public class EditPatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Connection con;
			Patient patientToEdit=null;
	        try {
	        	con=DbCon.getConnection();
	            int id = Integer.parseInt(request.getParameter("id"));
	            System.out.println("Id to edit: "+ id);
	            
	            PreparedStatement preparedStatement = con.prepareStatement("select  username,nom,prenom,tel,email,password from patient where id =?");
	            preparedStatement.setInt(1, id);
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println("l'execution dazt mzn");

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					
					String username= rs.getString("username");
					String nom= rs.getString("nom");
					String prenom = rs.getString("prenom");
					String tel =rs.getString("tel");
					String email =rs.getString("email");
					String password =rs.getString("password");
					
					patientToEdit = new Patient(id,username,nom,prenom,tel,email,password);
					System.out.println("l'execution dazt mzn");
				
				}}catch(Exception e) {
					e.printStackTrace();}
	           
	            request.setAttribute("patientToEdit" , patientToEdit);

	            request.getRequestDispatcher("admin/EditPageJspPat.jsp").forward(request, response);
			
			
		
	}

}
