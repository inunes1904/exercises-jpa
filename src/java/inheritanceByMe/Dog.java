package inheritanceByMe;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dogs")
public class Dog extends Animal{

}
