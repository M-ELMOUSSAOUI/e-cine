package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Membre;

public class MembreService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Membre> findAll() {

    	Query query = entityManager.createQuery("SELECT p FROM Produit p");
    	ArrayList<Membre> membres = new ArrayList<Membre>();
    	List<Membre> list = query.getResultList();
    	 for (Membre p : list) {
    		 Membre membre = new Membre();
    		 membre.setEmail(p.getEmail());
    		 membre.setId(p.getId());
    		 membre.setPassword(p.getPassword());
    		 membre.setUsername(p.getUsername());
    		 
    		 membres.add(membre);

		  }
		return membres;
	}

	public Membre get(long id) {
		entityManager.getTransaction().begin();
		Membre membre = entityManager.find(Membre.class, id);
		System.out.println(membre);
		entityManager.getTransaction().commit();
		return membre;
	}

	public void add(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.persist(membre);
		entityManager.getTransaction().commit();
	}

	public void update(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.merge(membre);
		entityManager.getTransaction().commit();
	}

	public void delete(Membre membre) {
		entityManager.getTransaction().begin();
		entityManager.remove(membre);
		entityManager.getTransaction().commit();
	}

	// remove product from table
	public void deleteById(Long id) {
		Membre membre = entityManager.find(Membre.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(membre);
		entityManager.getTransaction().commit();
	}
}

