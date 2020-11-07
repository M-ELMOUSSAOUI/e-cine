package com.watchme.models;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Programme implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id ;
	private Date dateProjection;
	private Date  heureDebut;
	private Date heureFin;
	 
	//bi-directional many-to-one association to Salle
		@ManyToOne(fetch=FetchType.LAZY)
		private Salle salle;
	
	//constructeurs
	public Programme() {
		
	}
	public Programme( Date dateProjection, Date heureDebut, Date heureFin) {
		super();
		this.dateProjection = dateProjection;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	
	//getters setters
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
	
	
	
}
