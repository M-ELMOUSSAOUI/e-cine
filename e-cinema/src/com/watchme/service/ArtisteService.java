package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Acteur;
import com.watchme.models.Artiste;

public class ArtisteService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();

	// just For Artiste
	@SuppressWarnings("unchecked")
	public List<Artiste> findByArtiste(String keyWord) {

		Query q = em.createQuery("SELECT a FROM Artiste a WHERE a.nom LIKE :key ").setParameter("key",
				"%" + keyWord + "%");

		return q.getResultList();

	}

	public List<Artiste> findAll() {
		Query query = em.createQuery("SELECT a FROM Artiste a");
		List<Artiste> artistes = new ArrayList<Artiste>();
		List<Artiste> list = query.getResultList();
		for (Artiste a : list) {
			Artiste artiste = new Artiste();
			artiste.setId(a.getId());
			artiste.setNom(a.getNom());
			artistes.add(artiste);
		}
		return artistes;
	}

	public Artiste get(long id) {
		return em.find(Artiste.class, id);
	}

	public void add(Artiste artiste) {
		em.getTransaction().begin();
		em.persist(artiste);
		em.getTransaction().commit();
	}

	public void update(Artiste artiste) {
		em.getTransaction().begin();
		em.merge(artiste);
		em.getTransaction().commit();

	}

	// close connection
	public void Close() {
		em.close();
	}

	public void delete(Artiste artiste) {
		em.getTransaction().begin();
		em.remove(artiste);
		em.getTransaction().commit();
	}

}
