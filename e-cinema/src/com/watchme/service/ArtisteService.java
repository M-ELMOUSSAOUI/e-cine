package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Artiste;


public class ArtisteService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	//just For Artiste
	@SuppressWarnings("unchecked")
	public List<Artiste> findByArtiste(String keyWord) {

		Query q = entityManager.createQuery("SELECT a FROM Artiste a WHERE a.nom LIKE :key ").setParameter("key",
				"%" + keyWord + "%");

		return q.getResultList();

	}
	

	public List<Artiste> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Artiste> artistes = entityManager.createQuery("SELECT a FROM Artiste AS a", Artiste.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return artistes;
	}

	public Artiste get(long id) {
		entityManager.getTransaction().begin();
		Artiste artiste = entityManager.find(Artiste.class, id);
		System.out.println(artiste);
		entityManager.getTransaction().commit();
		entityManager.close();
		return artiste;
	}


	public void add(Artiste artiste) {
		entityManager.getTransaction().begin();
		entityManager.persist(artiste);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Artiste artiste) {
		entityManager.getTransaction().begin();
		entityManager.merge(artiste);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Artiste artiste) {
		entityManager.getTransaction().begin();
		entityManager.remove(artiste);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
