
package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Acteur;

public class ActeurService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();

	// GET ALL Acteurs
	public List<Acteur> findAll() {

		Query query = em.createQuery("SELECT a FROM Acteur a");
		List<Acteur> acteurs = new ArrayList<Acteur>();
		List<Acteur> list = query.getResultList();
		for (Acteur a : list) {
			Acteur acteur = new Acteur();
			acteur.setId(a.getId());
			acteur.setFilms(a.getFilms());
			acteur.setNom(a.getNom());
			acteur.setRole(a.getRole());
			acteurs.add(acteur);
		}
		return acteurs;

	}

	// get acteur by id
	public Acteur findById(Long id) {

		return  em.find(Acteur.class, id);
	}

	// insert new acteur in table
	public void save(Acteur acteur) {
		em.getTransaction().begin();
		em.persist(acteur);
		em.getTransaction().commit();

	}

	// close connection
	public void Close() {
		em.close();
	}

	// update acteur
	public void update(Acteur acteur) {
		em.getTransaction().begin();
		em.merge(acteur);
		em.getTransaction().commit();
	}

	// remove acteur from table
	public void deleteById(Long id) {
		Acteur acteur = em.find(Acteur.class, id);
		em.getTransaction().begin();
		em.remove(acteur);
		em.getTransaction().commit();
	}

}

