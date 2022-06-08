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


public class PatientDaoImp {
	
	  private Connection con;
	  private static String query;
	  private static PreparedStatement pst;
	  private static ResultSet rs;
	  
	  public PatientDaoImp(Connection con) {
			
			this.con = con;
		}
	
	  public List<Patient> getAllPatients(){
		    List<Patient> patients = new ArrayList<Patient>();
		    try {
				query = "select * from patient ";
				pst = this.con.prepareStatement(query);
				rs = pst.executeQuery();
				while(rs.next()) {
					Patient row = new Patient();
					row.setId(rs.getInt("id"));
					row.setNom(rs.getString("nom"));
					row.setUsername(rs.getString("username"));
					row.setPrenom(rs.getString("prenom"));
					row.setTel(rs.getString("tel"));
					row.setEmail(rs.getString("email"));
					row.setPassword(rs.getString("password"));
					

					patients.add(row);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return patients;
	    }
	  
	  
	  public static Patient selectPatient(int id) throws ClassNotFoundException {
			Patient pat = null;
			// Step 1: Establishing a Connection
			try {
					query = "select id,username,nom,prenom,tel,email,password from patient where id =? ";
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
					
					
					
					pat = new Patient(id,username, nom, prenom,tel,email,password);
				}
			} catch (SQLException e) {
				
			}
			return pat;
		}
	

}
