package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Film;
import com.watchme.models.Salle;
import com.watchme.models.Seance;
import com.watchme.service.FilmService;
import com.watchme.service.SalleService;
import com.watchme.service.SeanceService;

@ManagedBean(name = "seances", eager = true)
@SessionScoped
public class SeanceBean {

	public Long idFilm ;
	private long idSalle ; 
	public ArrayList<Seance> allseances;
	public ArrayList<Film> allfilms ;
	public ArrayList<Salle> allSalles ;
	public Seance seance;
	private Long selectedId;
	public SeanceService seanceservice = new SeanceService();
	public FilmService filmService = new FilmService();
	public SalleService salleService = new SalleService();
	private Seance seanceToUpdate = new Seance();
	private Seance seanceToAdd = new Seance();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;

	
	public ArrayList<Film> getAllfilms() {
		allfilms = (ArrayList<Film>) filmService.findAll();
		return allfilms;
	}

	public void setAllfilms(ArrayList<Film> allfilms) {
		this.allfilms = allfilms;
	}
	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addSalle() {

		// salleToAdd.setCategorie(categorieservice.findById(idCategorie));
		seanceToAdd.setSalle(salleService.findById(this.idSalle));
		seanceToAdd.setFilm(filmService.findById(this.idFilm));
		seanceservice.save(seanceToAdd);
		seanceToAdd = new Seance();
		addMode = false;
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
		seanceToUpdate = seanceservice.findById(selectedId);
		System.err.println(seanceToAdd.getFilm());
	}

	/**
	    
	 */
	public void updateSalle() {

		seanceservice.update(this.seanceToUpdate);
		editMode = false;
	}

	public void delete(Long id) {

		seanceservice.deleteById(id);
		allseances = (ArrayList<Seance>) seanceservice.findAll();
	}
	
	
	       // Count number of Seances
			public int count() {
				return seanceservice.findAll().size();
			}

	public ArrayList<Seance> getAllseances() {
		allseances = (ArrayList<Seance>) seanceservice.findAll();
		return allseances;
	}

	public void setAllseances(ArrayList<Seance> allseance) {
		this.allseances = allseance;
	}

	public Seance getSeance() {
		return seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public SeanceService getSeanceservice() {
		return seanceservice;
	}

	public void setSeanceservice(SeanceService seanceservice) {
		this.seanceservice = seanceservice;
	}

	public Seance getSeanceToUpdate() {
		return seanceToUpdate;
	}

	public void setSeanceToUpdate(Seance seanceToUpdate) {
		this.seanceToUpdate = seanceToUpdate;
	}

	public Seance getSeanceToAdd() {
		return seanceToAdd;
	}

	public void setSeanceToAdd(Seance seanceToAdd) {
		this.seanceToAdd = seanceToAdd;
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

	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	public FilmService getFilmService() {
		return filmService;
	}

	public void setFilmService(FilmService filmService) {
		this.filmService = filmService;
	}

	public long getIdSalle() {
		return idSalle;
	}

	public void setIdSalle(long idSalle) {
		this.idSalle = idSalle;
	}

	public ArrayList<Salle> getAllSalles() {
		allSalles = salleService.findAll();
		return allSalles;
	}

	public void setAllSalles(ArrayList<Salle> allSalles) {
		this.allSalles = allSalles;
	}

	public SalleService getSalleService() {
		return salleService;
	}

	public void setSalleService(SalleService salleService) {
		this.salleService = salleService;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
