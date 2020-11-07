package com.watchme.models;

import javax.persistence.Entity;

@Entity 
public class Realisateur extends Artiste {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nationalite ;
	
	
	
	
	public Realisateur(String nationalite) {
		super();
		this.nationalite = nationalite;
	}
	public Realisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	
	

}
