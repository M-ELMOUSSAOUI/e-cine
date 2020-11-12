package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Seance;
import com.watchme.service.SeanceService;

@ManagedBean(name = "seances", eager = true)
@SessionScoped
public class SeanceBean {

	public ArrayList<Seance> allseance;
	public Seance seance;
	private Long selectedId;
	public SeanceService seanceservice = new SeanceService();
	private Seance seanceToUpdate = new Seance();
	private Seance seanceToAdd = new Seance();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addSalle() {

		// salleToAdd.setCategorie(categorieservice.findById(idCategorie));
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
		allseance = (ArrayList<Seance>) seanceservice.findAll();
	}
	
	
	       // Count number of Seances
			public int count() {
				return seanceservice.findAll().size();
			}

	public ArrayList<Seance> getAllseance() {
		allseance = (ArrayList<Seance>) seanceservice.findAll();
		return allseance;
	}

	public void setAllseance(ArrayList<Seance> allseance) {
		this.allseance = allseance;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
