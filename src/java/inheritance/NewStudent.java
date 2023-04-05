package inheritance;


import infrastructure.DAO;

public class NewStudent {

	
	public static void main(String[] args) {
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercises-jpa");
		//EntityManager em = emf.createEntityManager();
		
		DAO<Student> studentDAO = new DAO<>();
		
		Student stdOne = new Student(123L,"Joao");
		
		ScholarshipStudent stdTwo = new ScholarshipStudent(125L,"Joao", 2250.00);
		
		//em.getTransaction().begin();
		//em.merge(stdOne);
		//em.merge(stdTwo);
		//em.getTransaction().commit();
		
		//emf.close();
		//em.close();
		
		studentDAO.includeAtomicMerge(stdOne);
		studentDAO.includeAtomicMerge(stdTwo);
		
		studentDAO.close();
		
	}
}
