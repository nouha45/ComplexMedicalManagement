package com.miola.complexeMedicale.controllers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.miola.complexeMedicale.Beans.*;



import com.miola.complexeMedicale.dao.*;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LoginDao logindao;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() {
        logindao = new LoginDao();
    }
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = (String)session.getAttribute("username");
        if(username==null) {
			request.setAttribute("status", "failed");
            System.out.println("non");
        }
        else {
            request.getRequestDispatcher("/home.jsp").forward(request, response);
            System.out.println("okkkk");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        String type = request.getParameter("type");
        System.out.println(username);
        LoginBean loginbean = new LoginBean();
        //Remplir LoginBean
        loginbean.setUsername(username);
        loginbean.setPassword(password);
        loginbean.setType(type);

        HttpSession session = request.getSession();




        try {
            if (logindao.validate(loginbean))
            {

                //Acquérir le nom et le prenom du patient
                logindao.setColumns(loginbean);
                int id = loginbean.getId();
                String nom = loginbean.getNom();
                String prenom = loginbean.getPrenom();
                String email = loginbean.getEmail();
                String tel = loginbean.getTel();
                session.setAttribute("id",id);
                session.setAttribute("nom",nom);
                session.setAttribute("prenom",prenom);
                session.setAttribute("username", username);
                session.setAttribute("email", email);
                session.setAttribute("tel", tel);

                if(loginbean.getType().equals("Admin")) {
                    request.getRequestDispatcher("dashboardAdmin.jsp").forward(request, response);
                    System.out.println("admin");
                } 
                
                else if(loginbean.getType().equals("Medecin")){
                    this.getServletContext().getRequestDispatcher("/HomeDoctor.jsp").forward(request, response);

                }
                else
                	
                {
                    request.getRequestDispatcher("/HomePatient.jsp").forward(request, response);

                }
            }
            else
            {
                request.getRequestDispatcher("/login.jsp").forward(request, response);

				request.setAttribute("status", "failed");
                System.out.println("makayn walu");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}