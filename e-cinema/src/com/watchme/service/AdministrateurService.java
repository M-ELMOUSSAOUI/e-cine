
package com.watchme.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.watchme.models.Administrateur;

public class AdministrateurService {

	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	EntityManager em = factory.createEntityManager();

	public boolean login(Administrateur administrateur) {
		try {

			TypedQuery<Administrateur> query = em.createQuery(
					"SELECT a FROM Administrateur a WHERE a.username = :username AND a.password = :pass",
					Administrateur.class);
			query.setParameter("username", administrateur.getUsername());
			query.setParameter("pass", administrateur.getPassword());
			query.getSingleResult();
			return true;

		} catch (Exception e) {
			System.out.println("" + e.getMessage());
			return false;
		}

	}

	public ArrayList<Administrateur> findAll() {

		Query query = em.createQuery("SELECT a FROM Administrateur a");
		ArrayList<Administrateur> administrateurs = new ArrayList<Administrateur>();
		List<Administrateur> list = query.getResultList();
		for (Administrateur a : list) {
			Administrateur adm = new Administrateur();
			adm.setId(a.getId());
			adm.setEmail(a.getEmail());
			adm.setPassword(a.getPassword());
			adm.setUsername(a.getUsername());
			administrateurs.add(adm);

		}
		return administrateurs;

	}

	public Administrateur findById(Long id) {

		return em.find(Administrateur.class, id);
	}

	public void save(Administrateur administrateur) {
		em.getTransaction().begin();
		em.persist(administrateur);
		em.getTransaction().commit();

	}

	public void Close() {
		em.close();
	}

	public void update(Administrateur administrateur) {
		em.getTransaction().begin();
		em.merge(administrateur);
		em.getTransaction().commit();
	}

	public void deleteById(Long id) {
		Administrateur administrateur = em.find(Administrateur.class, id);
		em.getTransaction().begin();
		em.remove(administrateur);
		em.getTransaction().commit();
	}

}

