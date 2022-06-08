package com.miola.complexeMedicale.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/InscriptionServlet")

public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("username");
		String unom = request.getParameter("nom");
		String uprenom = request.getParameter("prenom");
		String uemail = request.getParameter("email");
		String upass = request.getParameter("pass");
		String utel = request.getParameter("tel");
        String type = request.getParameter("type");
        RequestDispatcher dispatcher = null;
        Connection con=null;

		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con =DriverManager.getConnection("jdbc:mysql://localhost:3306/complexmedicale?useSSL=false","root","");
			PreparedStatement pst;
			
			if(type.equals("Medecin")) {
				pst=con.prepareStatement("insert into doctor(username,nom,prenom,tel,email,password,specialite) values (?,?,?,?,?,?)");
				pst.setString(1,uname);
				pst.setString(2,unom);
				pst.setString(3,uprenom);
				pst.setString(4,utel);
				pst.setString(5,uemail);
				pst.setString(6,upass);
				
				int rowCount = pst.executeUpdate();
				dispatcher = request.getRequestDispatcher("inscription.jsp");
				if(rowCount >0) {
					request.setAttribute("status", "success");
					
					
				}else {
					request.setAttribute("status", "failed");
				}

				dispatcher.forward(request, response);
				
			}else {
				pst=con.prepareStatement("insert into patient(username,nom,prenom,tel,email,password) values (?,?,?,?,?,?)");
				pst.setString(1,uname);
				pst.setString(2,unom);
				pst.setString(3,uprenom);
				pst.setString(4,utel);
				pst.setString(5,uemail);
				pst.setString(6,upass);
				
				int rowCount = pst.executeUpdate();
				dispatcher = request.getRequestDispatcher("inscription.jsp");
				if(rowCount >0) {
					request.setAttribute("status", "success");
					
					
				}else {
					request.setAttribute("status", "failed");
				}

				dispatcher.forward(request, response);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

