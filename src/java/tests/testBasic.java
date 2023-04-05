package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.User;

public class testBasic {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("exercises-jpa");
		EntityManager em = emf.createEntityManager();
		
		User user = new User("Manuela", "manuela@gmail.com");
		
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}
}