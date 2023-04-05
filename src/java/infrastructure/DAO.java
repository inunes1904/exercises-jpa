package infrastructure;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

// Generics class
public class DAO<E> {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classE;
	
	static {
		
		try {
			emf = Persistence.createEntityManagerFactory("exercises-jpa");
			
		} catch (Exception e) {
			
		}
		
	}
	
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classE) {
		this.classE = classE;
		em = emf.createEntityManager();
	}
	
	public DAO<E> openTransaction() {
		em.getTransaction().begin();
		return this;
	}
	public DAO<E> commitTransaction() {
		em.getTransaction().commit();
		return this;
	}
	public DAO<E> include(E entity) {
		em.persist(entity);
		return this;
	}
	
	public DAO<E> includeMerge(E entity) {
		em.merge(entity);
		return this;
	}
	
	public DAO<E> includeAtomicMerge(E entity) {
		return this.openTransaction().includeMerge(entity)
				.commitTransaction();
	}
	
	
	public DAO<E> includeAtomic(E entity) {
		return this.openTransaction().include(entity)
				.commitTransaction();
	}
	
	
	public List<E> getAll(){
		return this.getAll(10,0);
	}
	
	
	public List<E> getAll(int quantity, int offset) {
		if (classE == null) {
			throw new UnsupportedOperationException("Null Class");
		}
		
		String jpql = "select e from " + classE.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classE );
		query.setMaxResults(quantity);
		query.setFirstResult(offset);
	
		return query.getResultList();
	}
	
	public E obtainById(Object id) {
		return em.find(classE, id);
	}
	
	
	public void close() {
		em.close();
	}
	
	public List<E> querie(String nameQuerie, Object... params){
		TypedQuery<E> query = em.createNamedQuery(nameQuerie, classE);
		
		for (int i = 0; i < params.length; i+=2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		
		return query.getResultList();
	}
	
	
	public E querieOne(String nameQuerie, Object... params){
		List<E> list = querie(nameQuerie, params);
		return list.isEmpty() ? null : list.get(0);
	}
	 
	
}
