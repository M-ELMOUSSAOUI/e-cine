package com.watchme.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Programme;


public class ProgrammeService {
	

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager entityManager = factory.createEntityManager();
    
    public List<Programme> findAll() {
    	 entityManager.getTransaction().begin();
         //Create Query 
         List<Programme> programmes = entityManager.createQuery("SELECT p FROM Programme AS p", Programme.class).getResultList();
         entityManager.getTransaction().commit();
         entityManager.close();
         return programmes;
    }
    
	 
	public Programme get(long id) {
     entityManager.getTransaction().begin();
     Programme programme = entityManager.find(Programme.class, id);
     System.out.println(programme);
     entityManager.getTransaction().commit();
     entityManager.close();
		return programme;
	}
	
	
	public void add(Programme programme) {
		entityManager.getTransaction().begin();
		entityManager.persist(programme);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Programme programme) {
        entityManager.getTransaction().begin();
        entityManager.merge(programme);
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	
	public void delete(Programme programme) {
      entityManager.getTransaction().begin();
      entityManager.remove(programme);
      entityManager.getTransaction().commit();
      entityManager.close();
	}
    

}
