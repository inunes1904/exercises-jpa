package modelQuery;

import infrastructure.DAO;


public class ObtainAverageOfFilms {
	
	public static void main(String[] args) {
		
		DAO<FilmGrade> dao = new DAO<>(FilmGrade.class);
		FilmGrade gradeFilm = dao.querieOne("ObtainAverageOfFilms");
		
		System.out.println(gradeFilm.getAverage());
		dao.close();
	}

}
