package com.watchme.serviceM;

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
}
