package com.watchme.beans;

import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.watchme.models.Film;
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
	public Film film ;
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
        filmToAdd.setActeurs(acteurservice.findById(this.idActeur));
        filmToAdd.setGenre(genreservice.get(this.idGenre));
        filmToAdd.setRealisateur(realisateurservice.get(this.idrealisateur));
		filmservice.add(filmToAdd);
		filmToAdd=new Film();
		addMode = false;	
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     filmToUpdate= filmservice.findById(selectedId);
	     System.err.println(filmToAdd.getTitre());
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
		System.out.println("film bean");
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

	public long getIdrealisateur() {
		return idrealisateur;
	}

	public void setIdrealisateur(int idrealisateur) {
		this.idrealisateur = idrealisateur;
	}

	public ActeurService getActeurservice() {
		return acteurservice;
	}

	public void setActeurservice(ActeurService acteurservice) {
		this.acteurservice = acteurservice;
	}

	public GenreService getGenreservice() {
		return genreservice;
	}

	public void setGenreservice(GenreService genreservice) {
		this.genreservice = genreservice;
	}

	public RealisateurService getRealisateurservice() {
		return realisateurservice;
	}

	public void setRealisateurservice(RealisateurService realisateurservice) {
		this.realisateurservice = realisateurservice;
	}
	
	
	
	
	
}
