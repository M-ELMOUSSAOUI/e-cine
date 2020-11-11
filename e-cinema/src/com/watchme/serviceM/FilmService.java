package com.watchme.serviceM;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Film;


public class FilmService {


	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager entityManager = factory.createEntityManager();
    
    public List<Film> findAll() {
    	 entityManager.getTransaction().begin();
         //Create Query 
         List<Film> films = entityManager.createQuery("SELECT f FROM Film AS f", Film.class).getResultList();
         entityManager.getTransaction().commit();
         entityManager.close();
         return films;
    }
    
	 
	public Film get(long id) {
     entityManager.getTransaction().begin();
     Film film = entityManager.find(Film.class, id);
     System.out.println(film);
     entityManager.getTransaction().commit();
     entityManager.close();
		return film;
	}
	
	
	public void add(Film film ) {
		entityManager.getTransaction().begin();
		entityManager.persist(film);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(Film film) {
        entityManager.getTransaction().begin();
        entityManager.merge(film);
        entityManager.getTransaction().commit();
        entityManager.close();
	}

	
	public void delete(Film film) {
      entityManager.getTransaction().begin();
      entityManager.remove(film);
      entityManager.getTransaction().commit();
      entityManager.close();
	}
    
}
