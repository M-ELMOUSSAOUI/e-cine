package app;

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
    	boolean var =  as.login(new Administrateur("moussa","mohamed@gmaol.com","123456"));
    	 System.err.println(var);
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
     

 }
}
