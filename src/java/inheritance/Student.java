package inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity 
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type_std", length=2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ST")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long registration;
	
	private String name;

	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Student(Long registration, String name) {
		this.registration = registration;
		this.name = name;
	}



	public Long getRegistration() {
		return registration;
	}


	public void setRegistration(Long registration) {
		this.registration = registration;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
}
