package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	private static final String PERSISTENCE_UNIT_NAME = "Ecinema";
    private static EntityManagerFactory factory;
 public static void main(String[] args) {
	 
     factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
     EntityManager em = factory.createEntityManager();
     em.close();
     factory.close(); 
 }
}
