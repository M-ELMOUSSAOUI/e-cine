package com.watchme.models;

import javax.persistence.Entity;

@Entity 
public class Acteur extends Artiste {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String role;

	public Acteur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Acteur(String nom , String role) {
		super(nom);
		this.role = role ;
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
    

}
