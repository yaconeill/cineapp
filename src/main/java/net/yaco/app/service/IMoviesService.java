package net.yaco.app.service;

import java.util.List;

import net.yaco.app.model.Movie;

public interface IMoviesService {
	List<Movie> searchAll();
	Movie searchId(int idMovie);
}
