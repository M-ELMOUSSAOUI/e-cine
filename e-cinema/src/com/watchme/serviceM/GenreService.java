package com.watchme.serviceM;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Genre;

public class GenreService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Genre> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Genre> genres = entityManager.createQuery("SELECT p FROM Programme AS p", Genre.class).getResultList();
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

}
