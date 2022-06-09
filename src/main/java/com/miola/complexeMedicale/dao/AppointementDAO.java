package com.miola.complexeMedicale.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.miola.complexeMedicale.models.*;

public class AppointementDAO {
	 private Connection con;
	    private static String query;
	    private static PreparedStatement pst;
	    private static ResultSet rs;
	    
		public AppointementDAO(Connection con) {
			super();
			this.con = con;
		}
		
		public List<RendezVous> getAllAppById(int id){
		    List<RendezVous> appointements = new ArrayList<RendezVous>();
		    try {
				query = "select * from rv where id_p=? ";
				
				pst = this.con.prepareStatement(query);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				while(rs.next()) {
					RendezVous row = new RendezVous();
					row.setId(rs.getInt("id"));
					row.setId_d(rs.getInt("id_d"));
					row.setId_p(rs.getInt("id_p"));
					row.setDate(rs.getDate("date"));
					
					appointements.add(row);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return appointements;
	    }
		public List<RendezVous> getAllDocAppById(int id){
		    List<RendezVous> appointements = new ArrayList<RendezVous>();
		    try {
				query = "select * from rv where id_d=? ";
				
				pst = this.con.prepareStatement(query);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				while(rs.next()) {
					RendezVous row = new RendezVous();
					row.setId(rs.getInt("id"));
					row.setId_d(rs.getInt("id_d"));
					row.setId_p(rs.getInt("id_p"));
					row.setDate(rs.getDate("date"));
					
					appointements.add(row);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return appointements;
	    }

}