package oneToManyRelationship;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Date date;
	
	@OneToMany(mappedBy = "orders",fetch = FetchType.EAGER)
	private List<OrderItem> items; 
	
	
	public Orders() {
		this(new Date());
	}

	
	
	public Orders(Date date) {
	
		this.date = date;
	}


	public List<OrderItem> getItems() {
		return items;
	}



	public void setItems(List<OrderItem> items) {
		this.items = items;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
