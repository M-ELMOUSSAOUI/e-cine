
package com.watchme.service;

import java.util.ArrayList;
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
		Query q = entityManager.createQuery("SELECT g FROM Genre g WHERE g.nom LIKE :key ").setParameter("key",
				"%" + keyWord + "%");

		return q.getResultList();

	}

	public List<Genre> findAll() {
		Query query = entityManager.createQuery("SELECT g FROM Genre g");
		ArrayList<Genre> genres = new ArrayList<Genre>();
		List<Genre> list = query.getResultList();
		for (Genre g : list) {
			Genre genre = new Genre();
			genre.setFilms(g.getFilms());
			genre.setId(g.getId());
			genre.setNom(g.getNom());
			genres.add(genre);
		}
		return genres;
	}

	public Genre get(long id) {
		entityManager.getTransaction().begin();
		Genre genre = entityManager.find(Genre.class, id);
		System.out.println(genre);
		entityManager.getTransaction().commit();
		return genre;
	}

	public void add(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.persist(genre);
		entityManager.getTransaction().commit();
	}

	public void update(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.merge(genre);
		entityManager.getTransaction().commit();
	}

	public void delete(Genre genre) {
		entityManager.getTransaction().begin();
		entityManager.remove(genre);
		entityManager.getTransaction().commit();
	}

	// remove product from table
	public void deleteById(Long id) {
		Genre genre = entityManager.find(Genre.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(genre);
		entityManager.getTransaction().commit();
	}

}

