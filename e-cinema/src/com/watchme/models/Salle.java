package com.watchme.models;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Entity;

import javax.persistence.OneToMany;


@Entity
public class Salle  extends AbstractModel<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer numero;
	private Integer nombrePlace;
	//bi-directional one-to-many association to Programme
	@OneToMany(mappedBy="salle")
	private List<Programme> programmes;

	// Constructors
	public Salle(Integer numero, Integer nombrePlace) {
		super();
		this.numero = numero;
		this.nombrePlace = nombrePlace;
	}

	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters

	public Integer getNumero() {
		return numero;
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

	public List<Programme> getProgrammes() {
		return programmes;
	}

	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}

}
