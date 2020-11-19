package com.watchme.beans;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Film;
import com.watchme.models.Programme;
import com.watchme.models.Salle;
import com.watchme.service.FilmService;
import com.watchme.service.ProgrammeService;
import com.watchme.service.SalleService;


@ManagedBean(name = "programmes", eager = true)
@SessionScoped
public class ProgrammeBean {

	public Long idFilm;
	public Long idProgramme;
	private long idSalle;
	public ArrayList<Programme> allprogrammes;
	public ArrayList<Film> allfilms;
	public ArrayList<Salle> allSalles;
	private Long selectedId;
	public ProgrammeService programmeService = new ProgrammeService();
	public FilmService filmService = new FilmService();
	public SalleService salleService = new SalleService();
	private Programme programmeToUpdate = new Programme();
	private Programme programmeToAdd = new Programme();
	private boolean editMode = false;
	private boolean addMode = false;
	private boolean activate;
	private String data;
	private List<Programme> filteredprg;

	public boolean isActivate() {
		return activate;
	}

	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}


	public Programme getProgrammeToUpdate() {
		return programmeToUpdate;
	}

	public void setProgrammeToUpdate(Programme programmeToUpdate) {
		this.programmeToUpdate = programmeToUpdate;
	}

	public Programme getProgrammeToAdd() {
		return programmeToAdd;
	}

	public void setProgrammeToAdd(Programme programmeToAdd) {
		this.programmeToAdd = programmeToAdd;
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

	public Long getIdProgramme() {
		return idProgramme;
	}

	public void setIdProgramme(Long idProgramme) {
		this.idProgramme = idProgramme;
	}

	public ArrayList<Film> getAllfilms() {
		allfilms = filmService.findAll();

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
		allprogrammes = (ArrayList<Programme>) programmeService.findAll();
		return allprogrammes;
	}

	public void setAllprogrammes(ArrayList<Programme> allprogrammes) {
		this.allprogrammes = allprogrammes;
	}

	public void desactiver() {
		selectedId = Long.parseLong(data);
		this.programmeToUpdate = programmeService.findById(selectedId);
		programmeToUpdate.setActivate(activate);
		programmeService.update(programmeToUpdate);
	}

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addProgramme() {

		programmeToAdd.setActivate(true);
		programmeToAdd.setSalle(salleService.findById(this.idSalle));
		programmeToAdd.setFilm(filmService.findById(this.idFilm));
		int d = Integer.parseInt(programmeToAdd.getFilm().getDuree().toString());
		@SuppressWarnings("deprecation")
		int h = programmeToAdd.getHeureDebut().getHours() + d;
		Time heureFin = new Time(h, 0, 0);
		programmeToAdd.setHeureFin(heureFin);
		programmeService.save(programmeToAdd);
		programmeToAdd = new Programme();
		addMode = false;
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
		programmeToUpdate = programmeService.findById(selectedId);
		System.err.println(programmeToAdd.getFilm());
	}

	/**
	    
	 */
	public void updateProgramme() {
		int d = Integer.parseInt(programmeToUpdate.getFilm().getDuree().toString());
		@SuppressWarnings("deprecation")
		int h = programmeToUpdate.getHeureDebut().getHours() + d;
		Time heureFin = new Time(h, 0, 0);
		programmeToUpdate.setHeureFin(heureFin);
		programmeService.update(this.programmeToUpdate);
		editMode = false;
	}

	public void delete(Long id) {

		programmeService.deleteById(id);
		allprogrammes = (ArrayList<Programme>) programmeService.findAll();
	}

	// Count number of Seances
	public int count() {
		return programmeService.findAll().size();
	}

	public List<Programme> getFilteredprg() {
		return filteredprg;
	}

	public void setFilteredprg(List<Programme> filteredprg) {
		this.filteredprg = filteredprg;
	}

}
