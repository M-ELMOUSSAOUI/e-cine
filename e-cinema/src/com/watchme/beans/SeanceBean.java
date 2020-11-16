package com.watchme.beans;


import java.sql.Time;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Film;
import com.watchme.models.Programme;
import com.watchme.models.Salle;
import com.watchme.models.Seance;
import com.watchme.service.FilmService;
import com.watchme.service.ProgrammeService;
import com.watchme.service.SalleService;
import com.watchme.service.SeanceService;

@ManagedBean(name = "seances", eager = true)
@SessionScoped
public class SeanceBean {

	public Long idFilm;
	public Long idProgramme;
	private long idSalle;
	public ArrayList<Seance> allseances;
	public ArrayList<Film> allfilms;
	public ArrayList<Salle> allSalles;
	public Programme programme;
	public Seance seance;
	private Long selectedId;
	public ProgrammeService programmeService = new ProgrammeService();
	public ArrayList<Programme> allprogrammes;
	public SeanceService seanceservice = new SeanceService();
	public FilmService filmService = new FilmService();
	public SalleService salleService = new SalleService();
	private Seance seanceToUpdate = new Seance();
	private Seance seanceToAdd = new Seance();
	private boolean editMode = false;
	private boolean addMode = false;
	private boolean activate;
	private String data;

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
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

	public Programme getProgramme() {
		if(idProgramme != null)
		{programme = programmeService.get(idProgramme);

		System.out.println(programme.getDateFin());}
		return programme;
	}

	public void setProgramme(Programme programme) {

		this.programme = programme;
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

	public Long getIdProgramme() {
		return idProgramme;
	}

	public void setIdProgramme(Long idProgramme) {
		this.idProgramme = idProgramme;
	}

	public ArrayList<Film> getAllfilms() {
		allfilms = filmService.findAll();
		System.out.println("films.:" + allfilms.size());
		return allfilms;
	}

	public void setAllfilms(ArrayList<Film> allfilms) {
		this.allfilms = allfilms;
	}

	public ProgrammeService getProgrammeService() {
		return programmeService;
	}

	public void setProgrammeService(ProgrammeService programmeService) {

		this.programmeService = programmeService;
	}

	public ArrayList<Programme> getAllprogrammes() {
		allprogrammes = programmeService.findAll();
		return allprogrammes;
	}

	public void setAllprogrammes(ArrayList<Programme> allprogrammes) {
		this.allprogrammes = allprogrammes;
	}

	public void desactiver() {
		selectedId = Long.parseLong(data);
		this.seanceToUpdate = seanceservice.findById(selectedId);
		seanceToUpdate.setActivate(activate);
		seanceservice.update(seanceToUpdate);
	}

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addSeance() {

		seanceToAdd.setActivate(true);
		seanceToAdd.setSalle(salleService.findById(this.idSalle));
		seanceToAdd.setFilm(filmService.findById(this.idFilm));
		int d = Integer.parseInt(seanceToAdd.getFilm().getDuree().toString());
		@SuppressWarnings("deprecation")
		int h = seanceToAdd.getHeureDebut().getHours() + d;

		Time heureFin = new Time(h, 0, 0);
		seanceToAdd.setHeureFin(heureFin);

		seanceservice.save(seanceToAdd);
		System.out.println("add method" + h);
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
	public void updateSeance() {

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

}
