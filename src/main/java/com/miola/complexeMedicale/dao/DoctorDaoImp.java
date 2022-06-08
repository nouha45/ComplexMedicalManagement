package com.miola.complexeMedicale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import com.miola.complexeMedicale.models.*;
import com.miola.complexeMedicale.connection.*;

public class DoctorDaoImp {
    private Connection con;
    private static String query;
    private static PreparedStatement pst;
    private static ResultSet rs;
	private static final String SELECT_DOCTOR_BY_ID = "select id,nom,email,prenom from doctor where id =?";

    
	public DoctorDaoImp(Connection con) {
		
		this.con = con;
	}

	
    
    public List<Doctor> getAllDoctors(){
	    List<Doctor> doctors = new ArrayList<Doctor>();
	    try {
			query = "select * from doctor ";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Doctor row = new Doctor();
				row.setId(rs.getInt("id"));
				row.setNom(rs.getString("nom"));
				row.setPrenom(rs.getString("prenom"));
				row.setTel(rs.getString("tel"));
				row.setEmail(rs.getString("email"));
				row.setPassword(rs.getString("password"));
				row.setSpecialite(rs.getString("specialite"));
				row.setUsername(rs.getString("username"));

				doctors.add(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return doctors;
    }
    
    public static Doctor selectDoctor(int id) throws ClassNotFoundException {
		Doctor doc = null;
		// Step 1: Establishing a Connection
		try {
				query = "select id,username,nom,prenom,tel,email,specialite from doctor where id =? ";
				pst = DbCon.getConnection().prepareStatement(query);
				rs = pst.executeQuery();
				 
			pst.setInt(1, id);
			System.out.println(pst);
			// Step 3: Execute the query or update query
			ResultSet rs = pst.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String username = rs.getString("username");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String specialite = rs.getString("specialite");
				
				
				doc = new Doctor(id,username, nom, prenom,tel,email,password,specialite);
			}
		} catch (SQLException e) {
			
		}
		return doc;
	}
    
}
