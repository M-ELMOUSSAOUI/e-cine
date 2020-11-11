package com.watchme.models;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Salle   implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numero;
	private Integer nombrePlace;


	// Constructors
	public Salle(Integer numero, Integer nombrePlace) {
		super();
		this.numero = numero;
		this.nombrePlace = nombrePlace;
	}

	public Salle() {
		super();
	}

	// Getters and Setters

	public Integer getNumero() {
		return numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(Integer nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	

}
