package com.watchme.beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.watchme.models.Genre;
import com.watchme.service.GenreService;

@ManagedBean(name = "genres", eager = true)
@SessionScoped
public class GenreBean {

	public ArrayList<Genre> allgenres;
	public Genre genre;
	private Long selectedId;
	public GenreService genreservice = new GenreService();
	private Genre genreToUpdate = new Genre();
	private Genre genreToAdd = new Genre();
	private boolean editMode = false;
	private boolean addMode = false;
	private String data;

	


	public void addGenre() {
		// filmToAdd.setCategorie(categorieservice.findById(idCategorie));
		genreservice.add(genreToAdd);
		genreToAdd=new Genre();
		addMode = false;	
	}

	public void cancelAdd() {
		addMode = false;
	}

	public void edit() {
		editMode = true;
		selectedId = Long.parseLong(data);
	     genreToUpdate= genreservice.get(selectedId);
	     System.err.println(genreToAdd.getNom());
	}

	public void updateGenre() {
	
		genreservice.update(this.genreToUpdate);
		editMode=false;
	}
	public void delete(Long id) {

		genreservice.deleteById(id);
		allgenres = (ArrayList<Genre>) genreservice.findAll();
	}

	public ArrayList<Genre> getAllGenres() {
		allgenres = (ArrayList<Genre>) genreservice.findAll();
		return allgenres;
	}

	public void setAllGenres(ArrayList<Genre> allGenres) {
		this.allgenres = allGenres;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre Genre) {
		this.genre = Genre;
	}

	public Long getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(Long selectedId) {
		this.selectedId = selectedId;
	}

	public GenreService getGenreservice() {
		return genreservice;
	}

	public void setGenreservice(GenreService Genreservice) {
		this.genreservice = Genreservice;
	}

	public Genre getGenreToUpdate() {
		return genreToUpdate;
	}

	public void setGenreToUpdate(Genre GenreToUpdate) {
		this.genreToUpdate = GenreToUpdate;
	}

	public Genre getGenreToAdd() {
		return genreToAdd;
	}

	public void setGenreToAdd(Genre GenreToAdd) {
		this.genreToAdd = GenreToAdd;
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
