package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Acteur;
import com.watchme.models.Film;
import com.watchme.models.Genre;
import com.watchme.models.Realisateur;
import com.watchme.service.ActeurService;
import com.watchme.service.FilmService;
import com.watchme.service.GenreService;
import com.watchme.service.RealisateurService;

@ManagedBean(name="films")
@SessionScoped
public class FilmBean {
	
	private long idActeur ;
	private long idGenre ;
	private long idrealisateur ;
	public ArrayList<Film> allfilms;
	public ArrayList<Acteur> allActeur ;
	public ArrayList<Genre> allGenres;
	public ArrayList<Realisateur> allRealisateurs;
	public Film film ;
	private Genre genre ;
	private Realisateur realisateur;
	private Long selectedId;
	public FilmService filmservice = new FilmService();
	public ActeurService acteurservice = new ActeurService();
	public GenreService genreservice = new GenreService();
	public RealisateurService realisateurservice = new RealisateurService();
	private Film filmToUpdate = new Film();
	private Film filmToAdd = new Film();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;
	
	

	public void addFilm() {
        //filmToAdd.setActeurs(allActeur);
        filmToAdd.setGenre(genreservice.get(this.idGenre));
        filmToAdd.setRealisateur(realisateurservice.get(this.idrealisateur));
		filmservice.add(filmToAdd);
		filmToAdd=new Film();
		addMode = false;	
	}

	public void cancelAdd() {
		addMode = false;
	}
	public void cancelUpdate() {
		editMode = false;
	}
	public void prepareAdd() {
		addMode = true;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     filmToUpdate= filmservice.findById(selectedId);
	     
	}
	//
	public void show() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     filmservice.findById(selectedId);
	     
	}
	
	
	
	// Count number of Films
			public int count() {
				return filmservice.findAll().size();
			}

	
	public void updateFilm() {
	
		filmservice.update(this.filmToUpdate);
		editMode=false;
	}
	public void delete(Long id) {

		filmservice.deleteById(id);
		allfilms = (ArrayList<Film>) filmservice.findAll();
	}

	
	public ArrayList<Film> getAllfilms() {
		allfilms = (ArrayList<Film>) filmservice.findAll();
		return allfilms;
	}
	public void setAllfilms(ArrayList<Film> allfilms) {
		this.allfilms = allfilms;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public Long getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}
	public FilmService getFilmservice() {
		return filmservice;
	}
	public void setFilmservice(FilmService filmservice) {
		this.filmservice = filmservice;
	}
	public Film getFilmToUpdate() {
		return filmToUpdate;
	}
	public void setFilmToUpdate(Film filmToUpdate) {
		this.filmToUpdate = filmToUpdate;
	}
	public Film getFilmToAdd() {
		return filmToAdd;
	}
	public void setFilmToAdd(Film filmToAdd) {
		this.filmToAdd = filmToAdd;
	}
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Realisateur getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}

	public boolean isEditMode() {
		return editMode;
	}
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}
	public boolean isAddMode() {
		return addMode;
	}
	public void setAddMode(boolean addMode) {
		this.addMode = addMode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public long getIdActeur() {
		return idActeur;
	}

	public void setIdActeur(int idActeur) {
		this.idActeur = idActeur;
	}

	public long getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public ArrayList<Acteur> getAllActeur() {
		return allActeur;
	}

	public void setAllActeur(ArrayList<Acteur> allActeur) {
		this.allActeur = allActeur;
	}

	public ArrayList<Genre> getAllGenres() {

		allGenres = (ArrayList<Genre>) genreservice.findAll();
		return allGenres;
	}

	public void setAllGenres(ArrayList<Genre> allGenres) {
		this.allGenres = allGenres;
	}

	public ArrayList<Realisateur> getAllRealisateurs() {

		allRealisateurs = (ArrayList<Realisateur>) realisateurservice.findAll();
		return allRealisateurs;
	}

	public void setAllRealisateurs(ArrayList<Realisateur> allRealisateurs) {
		this.allRealisateurs = allRealisateurs;
	}

	public void setIdActeur(long idActeur) {
		this.idActeur = idActeur;
	}

	public void setIdGenre(long idGenre) {
		this.idGenre = idGenre;
	}

	public void setIdrealisateur(long idrealisateur) {
		this.idrealisateur = idrealisateur;
	}

	public long getIdrealisateur() {
		return idrealisateur;
	}

	public void setIdrealisateur(int idrealisateur) {
		this.idrealisateur = idrealisateur;
	}

	public ActeurService getActeurservice() {
		 acteurservice = (ActeurService) acteurservice.findAll();
		return acteurservice;
	}

	public void setActeurservice(ActeurService acteurservice) {
		this.acteurservice = acteurservice;
	}

	public GenreService getGenreservice() {
		genreservice = (GenreService) genreservice.findAll();
		return genreservice;
	}

	public void setGenreservice(GenreService genreservice) {
		this.genreservice = genreservice;
	}

	public RealisateurService getRealisateurservice() {
		realisateurservice = (RealisateurService) realisateurservice.findAll();
		return realisateurservice;
	}

	public void setRealisateurservice(RealisateurService realisateurservice) {
		this.realisateurservice = realisateurservice;
	}
	
	
	
	
	
}
