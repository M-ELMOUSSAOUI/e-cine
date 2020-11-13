package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Acteur;
import com.watchme.service.ActeurService;

@ManagedBean(name = "acteurs", eager = true)
@SessionScoped
public class ActeurBean {

	public ArrayList<Acteur> allacteurs;
	public Acteur acteur;
	private Long selectedId;
	public ActeurService acteurservice = new ActeurService();
	private Acteur acteurToUpdate = new Acteur();
	private Acteur acteurToAdd = new Acteur();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addActeur() {

		// salleToAdd.setCategorie(categorieservice.findById(idCategorie));
		acteurservice.save(acteurToAdd);
		acteurToAdd = new Acteur();
		addMode = false;
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
		acteurToUpdate = acteurservice.findById(selectedId);
	}

	public void updateActeur() {

		acteurservice.update(this.acteurToUpdate);
		editMode = false;
	}

	public void delete(Long id) {

		acteurservice.deleteById(id);
		allacteurs = (ArrayList<Acteur>) acteurservice.findAll();
	}

	public ArrayList<Acteur> getAllacteur() {
		allacteurs = (ArrayList<Acteur>) acteurservice.findAll();
		return allacteurs;
	}

	public void setAllacteur(ArrayList<Acteur> allacteur) {
		this.allacteurs = allacteur;
	}

	public Acteur getActeur() {
		return acteur;
	}

	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public ActeurService getActeurservice() {
		return acteurservice;
	}

	public void setActeurservice(ActeurService acteurservice) {
		this.acteurservice = acteurservice;
	}

	public Acteur getActeurToUpdate() {
		return acteurToUpdate;
	}

	public void setActeurToUpdate(Acteur acteurToUpdate) {
		this.acteurToUpdate = acteurToUpdate;
	}

	public Acteur getActeurToAdd() {
		return acteurToAdd;
	}

	public void setActeurToAdd(Acteur acteurToAdd) {
		this.acteurToAdd = acteurToAdd;
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
