package net.yaco.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.yaco.app.model.Movie;

@Repository
public interface MoviesRepository extends JpaRepository<Movie, Integer> {
	// Listado de peliculas filtradas por estatus
	public List<Movie> findByStatus_OrderByTitle(String status);
}
