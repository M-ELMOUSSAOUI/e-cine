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
	EntityManager em = factory.createEntityManager();

	// GET ALL Programmes
	public List<Programme> findAll() {

		Query query = em.createQuery("SELECT s FROM Programme s");
		List<Programme> programmes = new ArrayList<Programme>();
		List<Programme> list = query.getResultList();
		for (Programme a : list) {
			Programme programme = new Programme();
			programme.setId(a.getId());
			programme.setDateProjection(a.getDateProjection());
			programme.setFilm(a.getFilm());
			programme.setHeureDebut(a.getHeureDebut());
			programme.setHeureFin(a.getHeureFin());
			programme.setSalle(a.getSalle());
			programme.setActivate(a.getActivate());
			programmes.add(programme);
		}
		return programmes;

	}

	// get programme by id
	public Programme findById(Long id) {

		return em.find(Programme.class, id);
	}

	// insert new Programme in table
	public void save(Programme programme) {
		em.getTransaction().begin();
		em.persist(programme);
		em.getTransaction().commit();

	}

	// close connection
	public void Close() {
		em.close();
	}

	// update Programme
	public void update(Programme programme) {
		em.getTransaction().begin();
		em.merge(programme);
		em.getTransaction().commit();
	}

	// remove Programme from table
	public void deleteById(Long id) {
		Programme programme = em.find(Programme.class, id);
		em.getTransaction().begin();
		em.remove(programme);
		em.getTransaction().commit();
	}
	
	// update attribute activate
	public void updateActivate() {
		
	}

}
