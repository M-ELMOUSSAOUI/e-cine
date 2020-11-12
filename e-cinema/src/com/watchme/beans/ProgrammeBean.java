package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Programme;
import com.watchme.service.ProgrammeService;

@ManagedBean(name="programmes" , eager = true)
@SessionScoped
public class ProgrammeBean {
	

	public ArrayList<Programme> allprogrammes;
	public Programme programme;
	private Long selectedId;
	public ProgrammeService programmeservice = new ProgrammeService();
	private Programme programmeToUpdate = new Programme();
	private Programme programmeToAdd = new Programme();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;


	public void cancelUpdate() {
		editMode = false;
	}

	public void prepareAdd() {
		addMode = true;
	}

	public void addProgramme() {

		// programmeToAdd.setCategorie(categorieservice.findById(idCategorie));
		programmeservice.add(programmeToAdd);
		programmeToAdd=new Programme();
		addMode = false;	
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     programmeToUpdate=programmeservice.get(selectedId);
	     System.err.println(programmeToAdd.getDateDebut());
	}

	/**
	    
	 */
	public void updateProgramme() {
	
		programmeservice.update(this.programmeToUpdate);
		editMode=false;
	}
	public void delete(Long id) {

		programmeservice.deleteById(id);
		allprogrammes = (ArrayList<Programme>) programmeservice.findAll();
	}
	
	// Count number of programmes
			public int count() {
				return programmeservice.findAll().size();
			}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<Programme> getAllprogrammes() {
		allprogrammes = (ArrayList<Programme>) programmeservice.findAll();
		return allprogrammes;
	}

	public void setAllprogrammes(ArrayList<Programme> allprogrammes) {
		this.allprogrammes = allprogrammes;
	}
	

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public Programme getprogramme() {
		return programme;
	}

	public void setprogramme(Programme programme) {
		this.programme = programme;
	}

	public ProgrammeService getprogrammeservice() {
		
		return programmeservice;
	}

	public void setprogrammeservice(ProgrammeService programmeservice) {
		
		this.programmeservice = programmeservice;
	}

	public Programme getprogrammeToUpdate() {
		return programmeToUpdate;
	}

	public void setprogrammeToUpdate(Programme programmeToUpdate) {
		this.programmeToUpdate = programmeToUpdate;
	}

	public Programme getprogrammeToAdd() {
		return programmeToAdd;
	}

	public void setprogrammeToAdd(Programme programmeToAdd) {
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



	   

}
