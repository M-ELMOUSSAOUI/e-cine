package com.watchme.models;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Programme implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dateProjection;
	@Temporal(TemporalType.TIMESTAMP)
	private Date heureDebut;
	@Temporal(TemporalType.TIMESTAMP)
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
