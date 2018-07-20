package net.yaco.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.yaco.app.model.Movie;
import net.yaco.app.model.Schedule;
import net.yaco.app.repository.MoviesRepository;
import net.yaco.app.repository.SchedulesRepository;

@Service
public class MoviesServiceJPA implements IMoviesService{
	
	@Autowired
	private SchedulesRepository schedulesRepo;

	@Autowired
	private MoviesRepository moviesRepo;
	
	@Override
	public void insert(Movie movie) {
		moviesRepo.save(movie);
	}
	
	@Override
	public List<Movie> searchAll() {		
		return moviesRepo.findAll();
	}
	
	@Override
	public List<Movie> searchAllActive() {		
		return moviesRepo.findByStatus_OrderByTitle("active");
	}

	@Override
	public Movie searchId(int idMovie) {
		Optional<Movie> opt = moviesRepo.findById(idMovie);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
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
		moviesRepo.deleteById(idMovie);		
	}

	@Override
	public Page<Movie> searchAll(Pageable page) {
		return moviesRepo.findAll(page);
	}

	@Override
	public List<Movie> searchByDate(Date date) {
		List<Movie> movies = new LinkedList<>();
		
		// Buscamos en la tabla de horarios, [agrupando por idPelicula]
		List<Schedule> schedules = schedulesRepo.findByDate(date);

		// Formamos la lista final de Peliculas que regresaremos.
		for (Schedule h : schedules) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			movies.add(h.getMovie());
		}
		return movies;
	}

}
