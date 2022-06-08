package com.miola.complexeMedicale.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.miola.complexeMedicale.dao.*;
import com.miola.complexeMedicale.models.*;
import com.miola.complexeMedicale.connection.*;

/**
 * Servlet implementation class MakeAppoiServlet
 */

public class MakeAppoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public MakeAppoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
				
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	        RequestDispatcher dispatcher = null;

			Connection con = DbCon.getConnection();
			int id_d = Integer.parseInt(request.getParameter("id"));
			int id_p = Integer.parseInt(request.getParameter("id_p"));
			String date_rv = request.getParameter("date");
			
			PreparedStatement ps = con.prepareStatement("insert into rv(id_d,id_p,date) values(?,?,?)  ");
			ps.setInt(1, id_d);
			ps.setInt(2, id_p);
			ps.setString(3, date_rv);
			
			
			int rowCount = ps.executeUpdate();
			dispatcher = request.getRequestDispatcher("HomePatient.jsp");
			if(rowCount >0) {
				request.setAttribute("status", "success");
				
				
			}else {
				request.setAttribute("status", "failed");
			}
			dispatcher.forward(request, response);

			
			

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	

}
