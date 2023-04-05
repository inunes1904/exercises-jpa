package testOneToMany;

import infrastructure.DAO;
import model.Product;
import oneToManyRelationship.OrderItem;
import oneToManyRelationship.Orders;

public class NewOrderTest {

	public static void main(String[] args) {
		
		
		DAO<Object> dao = new DAO<>();
		
		Product prod = new Product("PS5", 499.99);
		Orders order = new Orders();
		OrderItem orderItem = new OrderItem(order, prod, 2);
		
		dao.openTransaction().include(prod).include(order)
		.include(orderItem).commitTransaction();
		
		dao.close();
		
	}
}
