package com.watchme.models;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Programme  extends AbstractModel<Long> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date dateProjection;
	private Date heureDebut;
	private Date heureFin;

	// bi-directional many-to-one association to Salle
	@ManyToOne(fetch = FetchType.LAZY)
	private Salle salle;

	// bi-directional one-to-many association to Film

	@OneToMany(mappedBy = "programme")
	private List<Film> films;

	// constructeurs
	public Programme() {

	}

	public Programme(Date dateProjection, Date heureDebut, Date heureFin) {
		super();
		this.dateProjection = dateProjection;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	// getters setters

	public Date getDateProjection() {
		return dateProjection;
	}

	public void setDateProjection(Date dateProjection) {
		this.dateProjection = dateProjection;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

}
