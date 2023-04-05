package manyToManyTests;

import java.util.List;

import infrastructure.DAO;
import manyTomany.Actor;
import manyTomany.Film;

public class ObtainMovies {
	
	public static void main(String[] args) {
				
		DAO<Film> dao = new DAO<>(Film.class);
		List<Film> films = dao.querie("filmGreaterThan", "grade", 8.5);
		
		for (Film film : films) {
			System.out.println(film.getName() + 
					" -> " + film.getGrade());
			for (Actor actor : film.getActors()) {
				System.out.println(actor.getName());
			}
		}
	}
	
}
