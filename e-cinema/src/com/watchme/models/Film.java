package com.watchme.models;

import java.io.Serializable;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String titre;
	private Double duree;
	private String description;
	private Date datederealisation;
	private String fiche;

	// bi-directional many-to-one association to Genre
	@ManyToOne(fetch = FetchType.LAZY)
	private Genre genre;

	// bi-directional many-to-many association to Acteur
	@ManyToMany(mappedBy = "films")
	private List<Acteur> acteurs;
	// bi-directional many-to-one association to Genre
	@ManyToOne(fetch = FetchType.LAZY)
	private Realisateur realisateur;

	// constructors
	public Film() {

	}

	public Film(String titre, Double duree, String description, Date datederealisation, String fiche, Genre genre,
			List<Acteur> acteurs, Realisateur realisateur) {
		super();
		this.titre = titre;
		this.duree = duree;

		this.description = description;
		this.datederealisation = datederealisation;
		this.fiche = fiche;
		this.genre = genre;
		this.acteurs = acteurs;
		this.realisateur = realisateur;
	}

	// getter setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Double getDuree() {
		return duree;
	}

	public void setDuree(Double duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDatederealisation() {
		return datederealisation;
	}

	public void setDatederealisation(Date datederealisation) {
		this.datederealisation = datederealisation;
	}

	public String getFiche() {
		return fiche;
	}

	public void setFiche(String fiche) {
		this.fiche = fiche;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Acteur> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Acteur> acteurs) {
		this.acteurs = acteurs;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

}
