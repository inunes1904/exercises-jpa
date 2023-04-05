package tests;

import java.util.List;

import infrastructure.ProductDAO;
import model.Product;

public class ObtainProducts {
	public static void main(String[] args) {
		
	
		ProductDAO dao = new ProductDAO();
		
		List<Product> products =  dao.getAll();
		
		for (Product product : products) {
			System.out.println("ID: "+product.getId()+
					" Name: "+product.getName()+" Price: "+product.getPrice());
		}
		
		double totalPrice = products.stream().map(p -> p.getPrice())
						   .reduce(0.0, (t, p) ->t+p).doubleValue();
		System.out.println("The total vlaue is: € "+totalPrice);
		
		dao.close();
	}
}
