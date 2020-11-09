package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Film;

public class FilmService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Film> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Film> films = entityManager.createQuery("SELECT f FROM Film AS f", Film.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return films;
	}

	public Film get(long id) {
		entityManager.getTransaction().begin();
		Film film = entityManager.find(Film.class, id);
		System.out.println(film);
		entityManager.getTransaction().commit();
		entityManager.close();
		return film;
	}

	public void add(Film film) {
		entityManager.getTransaction().begin();
		entityManager.persist(film);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

//	// Search for any Name and  titre of Acteur or Film
//	@SuppressWarnings("unchecked")
//	public List<Film> findByName(String keyWord) {
//
//		return entityManager
//				.createQuery("SELECT f FROM Film f WHERE f.titre LIKE :key OR f.genre LIKE :key OR f.acteurs LIKE :key OR f.realisateur LIKE :key")
//				.setParameter("key", "%" + keyWord + "%").getResultList();
//	}
	
   // Best way to search 
		@SuppressWarnings("unchecked")
		public List<Film> findBykey(String keyWord) {

			return entityManager
					.createQuery("SELECT f,a,g FROM  Film f, Artiste a, Genre g "
				            + "WHERE f.titre LIKE :key OR a.nom LIKE :key OR g.nom LIKE :key ")
					.setParameter("key", "%" + keyWord + "%").getResultList();
		}
		

		//find Just Name of Film 
		@SuppressWarnings("unchecked")
		public List<Film> findJustFilm(String keyWord) {
			Query q = entityManager.createQuery("SELECT f FROM Film f WHERE f.titre LIKE :key ").setParameter("key",
					"%" + keyWord + "%");

			return q.getResultList();

		}

	public void update(Film film) {
		entityManager.getTransaction().begin();
		entityManager.merge(film);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Film film) {
		entityManager.getTransaction().begin();
		entityManager.remove(film);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
