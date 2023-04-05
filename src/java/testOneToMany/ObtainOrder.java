package testOneToMany;

import infrastructure.DAO;
import oneToManyRelationship.OrderItem;
import oneToManyRelationship.Orders;

public class ObtainOrder {
	
	public static void main(String[] args) {
		
		DAO<Orders> dao = new DAO<>(Orders.class);
		Orders order = dao.obtainById(1L);
		dao.close();
		
		for (OrderItem item : order.getItems()) {
			System.out.println("Quantity: "+item.getQuantity()+" ProductName: "
								+item.getProduct().getName());
		}
		
		
	}

}
