package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Personne;

public class PersonneService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Personne> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Personne> personnes = entityManager.createQuery("SELECT p FROM Personne AS p", Personne.class)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return personnes;
	}

	public Personne get(long id) {
		entityManager.getTransaction().begin();
		Personne personne = entityManager.find(Personne.class, id);
		System.out.println(personne);
		entityManager.getTransaction().commit();
		entityManager.close();
		return personne;
	}

	public void add(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.persist(personne);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.merge(personne);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.remove(personne);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
