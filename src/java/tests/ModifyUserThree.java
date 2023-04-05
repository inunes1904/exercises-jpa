package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class ModifyUserThree {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercises-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		
		User user = em.find(User.class, 1L);
		em.detach(user);
		user.setEmail("batatafrita@gmail.com");
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}
}
