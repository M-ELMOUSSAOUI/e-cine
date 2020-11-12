package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Programme;

public class ProgrammeService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Programme> findAll() {

		Query query = entityManager.createQuery("SELECT p FROM Programme p");
		ArrayList<Programme> programmes = new ArrayList<Programme>();
		List<Programme> list = query.getResultList();
		for (Programme p : list) {
			Programme pro = new Programme();
			pro.setId(p.getId());
			pro.setDateDebut(p.getDateDebut());
			pro.setDateFin(p.getDateFin());
			programmes.add(pro);

		}
		return programmes;
	}

	public Programme get(long id) {
		entityManager.getTransaction().begin();
		Programme programme = entityManager.find(Programme.class, id);
		System.out.println(programme);
		entityManager.getTransaction().commit();
		return programme;
	}

	public void add(Programme programme) {
		entityManager.getTransaction().begin();
		entityManager.persist(programme);
		entityManager.getTransaction().commit();
	}

	public void update(Programme programme) {
		entityManager.getTransaction().begin();
		entityManager.merge(programme);
		entityManager.getTransaction().commit();
	}

	public void delete(Programme programme) {
		entityManager.getTransaction().begin();
		entityManager.remove(programme);
		entityManager.getTransaction().commit();
	}

	public void deleteById(Long id) {
		Programme programme = entityManager.find(Programme.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(programme);
		entityManager.getTransaction().commit();
	}
}
