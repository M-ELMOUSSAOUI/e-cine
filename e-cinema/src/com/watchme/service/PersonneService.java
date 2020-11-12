package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Personne;

public class PersonneService {

	private static final String PERSISTENCE_UNIT_NAME = "EcinentityManagera";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager entityManager = factory.createEntityManager();

	public List<Personne> findAll() {

    	Query query = entityManager.createQuery("SELECT p FROM Personne p");
    	ArrayList<Personne> personnes = new ArrayList<Personne>();
    	List<Personne> list = query.getResultList();
    	 for (Personne p : list) {
    		 Personne personne = new Personne();
    		 personne.setEmail(p.getEmail());
    		 personne.setPassword(p.getPassword());
    		 personne.setId(p.getId());
    		 personne.setUsername(p.getUsername());
    		 personnes.add(personne);
  
		  }
		return personnes;
	}

	public Personne get(long id) {
		entityManager.getTransaction().begin();
		Personne personne = entityManager.find(Personne.class, id);
		System.out.println(personne);
		entityManager.getTransaction().commit();
		return personne;
	}

	public void add(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.persist(personne);
		entityManager.getTransaction().commit();
	}

	public void update(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.merge(personne);
		entityManager.getTransaction().commit();
	}

	public void delete(Personne personne) {
		entityManager.getTransaction().begin();
		entityManager.remove(personne);
		entityManager.getTransaction().commit();
	}

	// remove personne from table
	public void deleteById(Long id) {
		Personne personne = entityManager.find(Personne.class, id);
		entityManager.getTransaction().begin();
		entityManager.remove(personne);
		entityManager.getTransaction().commit();
	}

}
