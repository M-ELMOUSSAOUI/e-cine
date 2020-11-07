package com.watchme.models;

import javax.persistence.Entity;


@Entity
public class Administrateur extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//Constructors
	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}

}
