package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Seance;

public class SeanceService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();

	// GET ALL Seances
	public List<Seance> findAll() {

		Query query = em.createQuery("SELECT s FROM Seance s");
		List<Seance> seances = new ArrayList<Seance>();
		List<Seance> list = query.getResultList();
		for (Seance a : list) {
			Seance seance = new Seance();
			seance.setId(a.getId());
			seance.setDateProjection(a.getDateProjection());
			seance.setFilm(a.getFilm());
			seance.setHeureDebut(a.getHeureDebut());
			seance.setHeureFin(a.getHeureFin());
			seance.setSalle(a.getSalle());
			seance.setActivate(a.getActivate());
			seances.add(seance);
		}
		return seances;

	}

	// get seance by id
	public Seance findById(Long id) {

		return em.find(Seance.class, id);
	}

	// insert new Seance in table
	public void save(Seance seance) {
		em.getTransaction().begin();
		em.persist(seance);
		em.getTransaction().commit();

	}

	// close connection
	public void Close() {
		em.close();
	}

	// update Seance
	public void update(Seance seance) {
		em.getTransaction().begin();
		em.merge(seance);
		em.getTransaction().commit();
	}

	// remove Seance from table
	public void deleteById(Long id) {
		Seance seance = em.find(Seance.class, id);
		em.getTransaction().begin();
		em.remove(seance);
		em.getTransaction().commit();
	}

}
