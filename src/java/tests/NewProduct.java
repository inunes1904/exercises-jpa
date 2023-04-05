package tests;

import infrastructure.DAO;
import model.Product;

public class NewProduct {
	
	public static void main(String[] args) {
		
		DAO<Product> dao = new DAO<>(Product.class);

		Product product2 = new Product("Pencil", 1.00);
		

		dao.includeAtomic(product2).close();
	}
}
