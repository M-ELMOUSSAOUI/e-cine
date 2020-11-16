package app;

import java.sql.Time;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.watchme.models.Acteur;
import com.watchme.models.Administrateur;
import com.watchme.models.Film;
import com.watchme.models.Programme;
import com.watchme.models.Realisateur;
import com.watchme.service.AdministrateurService;
import com.watchme.service.FilmService;

public class Test {
	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
    private static EntityManagerFactory factory;
 public static void main(String[] args) {
	 FilmService fs = new FilmService();
	 AdministrateurService as = new AdministrateurService();
     factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
     EntityManager em = factory.createEntityManager();
     
     try {
    	 
    	 fs.findAll().stream().forEach(e-> System.out.println(e.getTitre()));
    		Time heureFin = new Time(107820);
    		System.out.println(heureFin);
    	
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
     

 }
}
