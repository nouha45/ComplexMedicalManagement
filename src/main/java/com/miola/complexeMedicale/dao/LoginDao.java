package com.miola.complexeMedicale.dao;

import com.miola.complexeMedicale.Beans.*;

import java.sql.*;

public class LoginDao {
    public boolean validate(LoginBean loginbean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/complexmedicale", "root", "");
            String tablename = null;
            //Type d'utilisateur
            if(loginbean.getType().equals("Medecin"))
                tablename = "doctor";
            if(loginbean.getType().equals("Patient"))
                tablename = "patient";
            if(loginbean.getType().equals("Admin"))
                tablename = "admin";

            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement("select * from "+tablename+" where username = ? and password = ? ");
            statement.setString(1, loginbean.getUsername());
            statement.setString(2, loginbean.getPassword());


            ResultSet resultat = statement.executeQuery();
            status = resultat.next();


        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }

        return status;
    }


    public void setColumns(LoginBean loginbean) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/complexemed", "root", "");
            String tablename = null;
            //Type d'utilisateur
            if(loginbean.getType().equals("Medecin"))
                tablename = "medcin";
            if(loginbean.getType().equals("Patient"))
                tablename = "patient";
            if(loginbean.getType().equals("Admin"))
                tablename = "admin";

            // Step 2:Create a statement using connection object
            PreparedStatement statement = connection.prepareStatement("select * from "+tablename+" where username = ? and password = ? ");
            statement.setString(1, loginbean.getUsername());
            statement.setString(2, loginbean.getPassword());


            ResultSet resultat = statement.executeQuery();

            while(resultat.next()) {
                loginbean.setId(resultat.getInt("id"));
                loginbean.setNom(resultat.getString("nom"));
                loginbean.setPrenom(resultat.getString("prenom"));
                loginbean.setEmail(resultat.getString("email"));
                loginbean.setTel(resultat.getString("tel"));
            }
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
    }
}
