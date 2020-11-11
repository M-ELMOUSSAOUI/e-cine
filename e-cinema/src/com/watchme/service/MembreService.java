package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Membre;

public class MembreService {

	
	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();
	
	public List<Membre> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Membre> membres = entityManager.createQuery("SELECT m FROM Membre AS m", Membre.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return membres;
	}

	public Membre get(long id) {
		entityManager.getTransaction().begin();
		Membre membre = entityManager.find(Membre.class, id);
		System.out.println(membre);
		entityManager.getTransaction().commit();
		entityManager.close();
		return membre;
	}

	public void add(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.persist(membre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.merge(membre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.remove(membre);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
