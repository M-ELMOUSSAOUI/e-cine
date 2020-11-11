package com.watchme.serviceM;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Salle;

public class SalleService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Salle> findAll() {
		entityManager.getTransaction().begin();
		// Create Query
		List<Salle> salles = entityManager.createQuery("SELECT s FROM Salle AS s", Salle.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return salles;
	}

	public Salle get(long id) {
		entityManager.getTransaction().begin();
		Salle salle = entityManager.find(Salle.class, id);
		System.out.println(salle);
		entityManager.getTransaction().commit();
		entityManager.close();
		return salle;
	}

	public void add(Salle salle) {
		entityManager.getTransaction().begin();
		entityManager.persist(salle);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Salle salle) {
		entityManager.getTransaction().begin();
		entityManager.merge(salle);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Salle salle) {
		entityManager.getTransaction().begin();
		entityManager.remove(salle);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

}
