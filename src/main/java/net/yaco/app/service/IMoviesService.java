package net.yaco.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.yaco.app.model.Movie;

public interface IMoviesService {
	void insert(Movie movie);
	List<Movie> searchAll();
	Movie searchId(int idMovie);
	List<String> searchGenre();
	void delete(int idMovie);
	Page<Movie> searchAll(Pageable page);
	List<Movie> searchAllActive();
	List<Movie> searchByDate(Date date);
}
