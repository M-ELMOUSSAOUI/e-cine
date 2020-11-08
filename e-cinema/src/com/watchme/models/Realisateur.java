package com.watchme.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity 
public class Realisateur extends Artiste {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nationalite ;
	
	
	// bi-directional one-to-many association to Film

		@OneToMany(mappedBy = "realisateur")
		private List<Film> films;
	
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
