package manyTomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double grade;
	@ManyToMany(cascade= CascadeType.PERSIST)
	@JoinTable(name="actors_In_Movies",
	joinColumns = @JoinColumn(name="film_id",referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="actor_id",referencedColumnName="id")
	)
	private List<Actor> actors = new ArrayList<>();
	
	public Film() {
		// TODO Auto-generated constructor stub
	}

	public Film(String name, Double grade) {
		super();
		this.name = name;
		this.grade = grade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public List<Actor> getActors() {
		if (actors == null) {
			actors = new ArrayList<>();
		}
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	public void addActor(Actor actor) {
		if (actor != null && !getActors().contains(actor)) {
			getActors().add(actor);
			if (!actor.getFilms().contains(this)) {
				actor.getFilms().add(this);
			}
		}
		
	}
	
	
}
