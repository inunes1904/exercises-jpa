package oneToManyRelationship;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.Product;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	private Orders orders;
	
	@ManyToOne
	private Product product;
	
	@Column(nullable=false)
	private int quantity;

	@Column(nullable=false) 
	private Double price;
	
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	


	public OrderItem(Orders orders, Product product, int quantity) {
		
		this.setOrders(orders);
		this.setProduct(product);
		this.setQuantity(quantity);
	
	}


	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
		if (product != null && this.price == null) {
			this.setPrice(product.getPrice());
		}
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
}
