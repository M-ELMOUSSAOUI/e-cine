
package com.watchme.service;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Salle;

public class SalleService {
	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();

	// GET ALL salles
	public ArrayList<Salle> findAll() {

		Query query = em.createQuery("SELECT s FROM Salle s");
		ArrayList<Salle> salles = new ArrayList<Salle>();
		List<Salle> list = query.getResultList();
		for (Salle s : list) {
			Salle salle = new Salle();
			salle.setId(s.getId());
			salle.setNombrePlace(s.getNombrePlace());
			salle.setNumero(s.getNumero());

			salles.add(salle);

		}
		return salles;

	}

	// get salle by id
	public Salle findById(Long id) {

		return (Salle) em.find(Salle.class, id);
	}

	// insert new salle in table
	public void save(Salle salle) {
		em.getTransaction().begin();
		em.persist(salle);
		em.getTransaction().commit();

	}

	// close connection
	public void Close() {
		em.close();
	}

	// update salle
	public void update(Salle salle) {
		em.getTransaction().begin();
		em.merge(salle);
		em.getTransaction().commit();
	}

	// remove salle from table
	public void deleteById(Long id) {
		Salle salle = em.find(Salle.class, id);
		em.getTransaction().begin();
		em.remove(salle);
		em.getTransaction().commit();
	}

}
