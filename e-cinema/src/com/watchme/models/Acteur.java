package com.watchme.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn ;


@Entity 
public class Acteur extends Artiste {

	private static final long serialVersionUID = 1L;
	
    private String role;
	// bi-directional many-to-many association to Film
	@ManyToMany
	@JoinTable(
			  name = "Films_Acteurs_Associations" ,
			  joinColumns = @JoinColumn(name = "id_Acteur"), 
			  inverseJoinColumns = @JoinColumn(name = "id_Film"))
	private List<Film> films;
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

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	
    

}
