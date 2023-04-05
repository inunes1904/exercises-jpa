package manyToManyTests;

import infrastructure.DAO;
import manyTomany.Actor;
import manyTomany.Film;

public class NewMovieActor {

	public static void main(String[] args) {
		
		Film film = new Film("Star Wars Ep 4", 8.7);
		Film film2 = new Film("Harry Potter - Chamber of Secrets", 7.0);
		
		Actor actor = new Actor("Harrinson Ford");
		Actor actressB = new Actor("Carrie Fisher");
		
		
		film.addActor(actor);
		film.addActor(actressB);
		
		film2.addActor(actor);
		
		
		DAO<Film> dao = new DAO<>(Film.class);
		
		dao.includeAtomic(film2);
	}
	
}
