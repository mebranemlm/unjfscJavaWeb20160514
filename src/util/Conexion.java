package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexion {

	public EntityManager em =null;
	public EntityManagerFactory emf=null;
	public String open(){
		try {
			emf= Persistence.createEntityManagerFactory("persistence");
			em=emf.createEntityManager();
			return "Success";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public void close(){
		em.close();
		emf.close();
	}
}
