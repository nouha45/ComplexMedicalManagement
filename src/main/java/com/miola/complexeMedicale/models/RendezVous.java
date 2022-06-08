package com.miola.complexeMedicale.models;

import java.util.Date;

public class RendezVous {
	private int id;
	private int id_d;
	private int id_p;
	private Date date;
	
	public RendezVous() {}
	
	
	
	
	public RendezVous(int id, int id_d, int id_p, Date date) {
		super();
		this.id = id;
		this.id_d = id_d;
		this.id_p = id_p;
		this.date = date;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_d() {
		return id_d;
	}
	public void setId_d(int id_d) {
		this.id_d = id_d;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
