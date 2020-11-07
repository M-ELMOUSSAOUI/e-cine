package com.watchme.models;

import javax.persistence.Entity;


@Entity 
public class Membre extends Personne{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructors
	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membre(String username, String email, String password) {
		super(username, email, password);
		// TODO Auto-generated constructor stub
	}
	

}
