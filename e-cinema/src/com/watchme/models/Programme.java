package com.watchme.models;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Programme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Temporal(TemporalType.TIME)
	private Date heureDebut;
	@Temporal(TemporalType.TIME)
	private Date heureFin;
	@Temporal(TemporalType.DATE)
	private Date dateProjection;
	private Boolean activate ;
	@OneToOne
	private Salle salle;
	@OneToOne
	private Film film;

	// Constructors

	public Programme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Programme(Date heureDebut, Date heureFin, Date dateProjection, Boolean activate, Salle salle, Film film) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.dateProjection = dateProjection;
		this.activate = activate;
		this.salle = salle;
		this.film = film;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateProjection() {
		return dateProjection;
	}

	public void setDateProjection(Date dateProjection) {
		this.dateProjection = dateProjection;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}

}
