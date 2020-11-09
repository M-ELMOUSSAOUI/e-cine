package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Genre;

public class GenreService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	

	@SuppressWarnings("unchecked")
	public List<Genre> findByName(String keyWord) {
		Query q = entityManager.createQuery("SELECT g FROM genre g WHERE g.nom LIKE :key ").setParameter("key",
				"%" + keyWord + "%");

		return q.getResultList();

	}
	
	public List<Genre> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Genre> genres = entityManager.createQuery("SELECT g FROM Genre AS g", Genre.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return genres;
	}

	public Genre get(long id) {
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, id);
		System.out.println(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return genre;
	}

	public void add(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.persist(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.merge(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.remove(genre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
