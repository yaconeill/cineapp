package net.yaco.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;

import net.yaco.app.model.Movie;

//@Service
public class MoviesServiceImpl implements IMoviesService {

	private List<Movie> list = null;

	public MoviesServiceImpl() {
		//System.out.println("Creando la instancia");

		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");

		try {
			list = new LinkedList<>();

			Movie movie1 = new Movie();
			movie1.setId(1);
			movie1.setTitle("A Todo Gas");
			movie1.setDuration(120);
			movie1.setRating("B");
			movie1.setGenre("Action");
			movie1.setReleaseDate(formatter.parse("02-05-2017"));
			// image = "cinema.png"
			// status = "Active"

			Movie movie2 = new Movie();
			movie2.setId(2);
			movie2.setTitle("Deadpool");
			movie2.setDuration(140);
			movie2.setRating("B");
			movie2.setGenre("Action");
			movie2.setReleaseDate(formatter.parse("08-06-2017"));
			movie2.setImage("Deadpool.jpg");

			Movie movie3 = new Movie();
			movie3.setId(3);
			movie3.setTitle("Avengers");
			movie3.setDuration(130);
			movie3.setRating("B");
			movie3.setGenre("Action");
			movie3.setReleaseDate(formatter.parse("22-07-2017"));
			movie3.setImage("Avengers.jpg");

			Movie movie4 = new Movie();
			movie4.setId(4);
			movie4.setTitle("Kong La Isla Calavera");
			movie4.setDuration(118);
			movie4.setRating("B");
			movie4.setGenre("Acción y aventuras");
			movie4.setReleaseDate(formatter.parse("30-07-2017"));
			movie4.setImage("estreno4.png");
			movie4.setStatus("Inactive");

			Movie movie5 = new Movie();
			movie5.setId(5);
			movie5.setTitle("Life: Vida Inteligente");
			movie5.setDuration(104);
			movie5.setRating("B");
			movie5.setGenre("Drama");
			movie5.setReleaseDate(formatter.parse("10-06-2017"));
			movie5.setImage("estreno5.png");
			movie5.setStatus("Active");

			// Add movie objects to list
			list.add(movie1);
			list.add(movie2);
			list.add(movie3);
			list.add(movie4);
			list.add(movie5);
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public List<Movie> searchAll() {
		return list;
	}

	public Movie searchId(int idMovie) {
		for (Movie p : list) {
			if (p.getId() == idMovie) {
				return p;
			}
		}
		return null;
	}

	public void insert(Movie movie) {
		list.add(movie);
	}

	public List<String> searchGenre() {
		List<String> genres = new LinkedList<>();
		genres.add("Accion");
		genres.add("Aventuras");
		genres.add("Clasicas");
		genres.add("Comedia Romantica");
		genres.add("Drama");
		genres.add("Terror");
		genres.add("Accion y Aventura");
		genres.add("Romantica");
		genres.add("Ciencia Ficción");
		
		return genres;
	}

	@Override
	public void delete(int idMovie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Movie> searchAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> searchAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> searchByDate(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}