package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Realisateur;


public class RealisateurService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Realisateur> findAll() {
		Query query = entityManager.createQuery("SELECT r FROM Realisateur r");
		ArrayList<Realisateur> realisateurs = new ArrayList<Realisateur>();
		List<Realisateur> list = query.getResultList();
		for (Realisateur p : list) {
			Realisateur realisateur = new Realisateur();
			realisateur.setId(p.getId());
			realisateur.setNationalite(p.getNationalite());
			realisateur.setNom(p.getNom());
			realisateurs.add(realisateur);
		}
		return realisateurs;

	}

	public Realisateur get(long id) {
		entityManager.getTransaction().begin();
		Realisateur realisateur = entityManager.find(Realisateur.class, id);
		System.out.println(realisateur);
		entityManager.getTransaction().commit();
		return realisateur;
	}

	public void add(Realisateur realisateur) {
		entityManager.getTransaction().begin();
		entityManager.persist(realisateur);
		entityManager.getTransaction().commit();
	}

	public void update(Realisateur realisateur) {
		entityManager.getTransaction().begin();
		entityManager.merge(realisateur);
		entityManager.getTransaction().commit();
	}

	public void delete(Realisateur realisateur) {
		entityManager.getTransaction().begin();
		entityManager.remove(realisateur);
		entityManager.getTransaction().commit();
	}

	// remove product from table
	public void deleteById(Long id) {
		Realisateur realisateur = entityManager.find(Realisateur.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(realisateur);
		entityManager.getTransaction().commit();
	}
}
