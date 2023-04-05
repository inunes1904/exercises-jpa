package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class RemoveUser {
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercises-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		User user = em.find(User.class, 5L);
		
		if (user != null) {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
		}
		
		em.clear();
		emf.close();
		
	}

}
