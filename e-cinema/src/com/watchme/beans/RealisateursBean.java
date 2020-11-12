package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Realisateur;
import com.watchme.service.RealisateurService;

@ManagedBean(name="realisateurs" , eager = true)
@SessionScoped
public class RealisateursBean {

	
	

	public ArrayList<Realisateur> allrealisateurs;
	public Realisateur realisateur;
	private Long selectedId;
	public RealisateurService realisateurservice = new RealisateurService();
	private Realisateur realisateurToUpdate = new Realisateur();
	private Realisateur realisateurToAdd = new Realisateur();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;

	

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addRealisateur() {

		// salleToAdd.setCategorie(categorieservice.findById(idCategorie));
		realisateurservice.add(realisateurToAdd);
		realisateurToAdd=new Realisateur();
		addMode = false;	
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     realisateurToUpdate= realisateurservice.get(selectedId);
	     System.err.println(realisateur.getNationalite());
	}

	/**
	    
	 */
	public void updateSalle() {
	
		realisateurservice.update(this.realisateurToUpdate);
		editMode=false;
	}
	public void delete(Long id) {

		realisateurservice.deleteById(id);
		allrealisateurs = (ArrayList<Realisateur>) realisateurservice.findAll();
	}


	
	public ArrayList<Realisateur> getAllrealisateurs() {
		allrealisateurs = (ArrayList<Realisateur>) realisateurservice.findAll();
		return allrealisateurs;
	}
	public void setAllrealisateurs(ArrayList<Realisateur> allrealisateurs) {
		this.allrealisateurs = allrealisateurs;
	}
	public Realisateur getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Realisateur realisateur) {
		this.realisateur = realisateur;
	}
	public Long getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}
	public RealisateurService getRealisateurservice() {
		return realisateurservice;
	}
	public void setRealisateurservice(RealisateurService realisateurservice) {
		this.realisateurservice = realisateurservice;
	}
	public Realisateur getRealisateurToUpdate() {
		return realisateurToUpdate;
	}
	public void setRealisateurToUpdate(Realisateur realisateurToUpdate) {
		this.realisateurToUpdate = realisateurToUpdate;
	}
	public Realisateur getRealisateurToAdd() {
		return realisateurToAdd;
	}
	public void setRealisateurToAdd(Realisateur realisateurToAdd) {
		this.realisateurToAdd = realisateurToAdd;
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
