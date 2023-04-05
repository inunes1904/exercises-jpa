package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student{

	private double scholarshipValue;
	
	
	public ScholarshipStudent() {
		// TODO Auto-generated constructor stub
	}

	public ScholarshipStudent(Long registration, String name, double scholarshipValue) {
		super(registration, name);
		this.scholarshipValue = scholarshipValue;
		
	}

	public double getScholarshipValue() {
		return scholarshipValue;
	}

	public void setScholarshipValue(double scholarshipValue) {
		this.scholarshipValue = scholarshipValue;
	}
	
	
	
}
