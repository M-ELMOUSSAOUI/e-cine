package com.watchme.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.watchme.models.Administrateur;

public class AdministrateurService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager entityManager = factory.createEntityManager();
    

    public boolean login(Administrateur administrateur) {
		try {
			
			Query query = entityManager.createQuery("SELECT a FROM Administrateur a WHERE a.username = :username AND u.password = :password\r\n"+ "");
	        query.setParameter(1, administrateur.getUsername());
	        query.setParameter(2,administrateur.getPassword()); 
	        query.getSingleResult();
			return true;

		} catch (Exception e) {
			System.out.println(""+e.getMessage());
			return false;
		}

	}

     // Get Administrateur par ID
	public Administrateur get(long id) {
		entityManager.getTransaction().begin();
		Administrateur administrateur= entityManager.find(Administrateur.class, id);
		System.out.println(administrateur);
		entityManager.getTransaction().commit();
		entityManager.close();
		return administrateur;
	}

	public void add(Administrateur administrateur) {
		entityManager.getTransaction().begin();
		entityManager.persist(administrateur);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Administrateur administrateur) {
		entityManager.getTransaction().begin();
		entityManager.merge(administrateur);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void delete(Administrateur administrateur) {
		entityManager.getTransaction().begin();
		entityManager.remove(administrateur);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

