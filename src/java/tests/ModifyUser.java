package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class ModifyUser {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercises-jpa");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		User user = em.find(User.class, 5L);
		user.setName("Brandoa");
		user.setEmail("Brandoa@gmail.com");
		
		em.merge(user);
		em.getTransaction().commit();
		
	
		
		em.clear();
		emf.close();
	
	}

}
