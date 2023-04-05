package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class GetUser {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercises-jpa");
		EntityManager em = emf.createEntityManager();
				
		
		User user = em.find(User.class, 1L);
		System.out.println(user.getName());

		
		em.close();
		emf.close();
	}

}