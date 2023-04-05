package manyToManyTests;

import infrastructure.DAO;
import manyTomany.Nephew;
import manyTomany.Uncle;

public class NewUncleNephew {

	public static void main(String[] args) {
		Uncle uncle1 = new Uncle("Maria");
		Uncle uncle2 = new Uncle("Jose");
		
		Nephew neph1 = new Nephew("Pedro");
		Nephew neph2 = new Nephew("Andre");
		
		uncle1.getNephews().add(neph1);
		neph1.getUncles().add(uncle1);
		
		uncle1.getNephews().add(neph2);
		neph2.getUncles().add(uncle1);
		
		uncle2.getNephews().add(neph1);
		neph1.getUncles().add(uncle2);
		
		uncle2.getNephews().add(neph2);
		neph2.getUncles().add(uncle2);
		
		
		DAO<Object> dao = new DAO<>();
		
		
		dao.openTransaction().include(uncle1)
		.include(uncle2).include(neph1).include(neph2)
		.commitTransaction().close();
	}
}
