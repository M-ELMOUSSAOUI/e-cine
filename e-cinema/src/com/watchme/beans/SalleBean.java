package com.watchme.beans;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.watchme.models.Salle;
import com.watchme.service.SalleService;

@ManagedBean(name = "salles", eager = true)
@SessionScoped
public class SalleBean {

	public ArrayList<Salle> allsalles;
	public Salle salle;
	public SalleService salleservice = new SalleService();
	private Salle salleToUpdate = new Salle();
	private Salle salleToAdd = new Salle();
	private boolean editMode = false;
	private boolean addMode = false;

	public ArrayList<Salle> getAllsalles() {
		allsalles = salleservice.findAll();
		return allsalles;
	}

	public void setAllsalles(ArrayList<Salle> allsalles) {
		this.allsalles = allsalles;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public SalleService getSalleservice() {
		
		return salleservice;
	}

	public void setSalleservice(SalleService salleservice) {
		
		this.salleservice = salleservice;
	}

	public Salle getSalleToUpdate() {
		return salleToUpdate;
	}

	public void setSalleToUpdate(Salle salleToUpdate) {
		this.salleToUpdate = salleToUpdate;
	}

	public Salle getSalleToAdd() {
		return salleToAdd;
	}

	public void setSalleToAdd(Salle salleToAdd) {
		this.salleToAdd = salleToAdd;
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

	

	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addSalle() {

		// salleToAdd.setCategorie(categorieservice.findById(idCategorie));
		salleservice.save(salleToAdd);

		addMode = false;
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
	}

	public void updateSalle() {
		FacesContext fc = FacesContext.getCurrentInstance();
	      Map<String,String> params = 
	         fc.getExternalContext().getRequestParameterMap();
	      	Long id =  Long.parseLong(params.get("idToEdit"));
	      	System.out.println(id);
	      	salle=salleservice.findById(id);
				salleservice.update(this.salle);
				editMode=false;
	}
	public void delete(Long id) {

		salleservice.deleteById(id);
		allsalles = (ArrayList<Salle>) salleservice.findAll();
	}

}