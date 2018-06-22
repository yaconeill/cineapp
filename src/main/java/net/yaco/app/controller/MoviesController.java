package net.yaco.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.yaco.app.model.Movie;

@Controller
@RequestMapping("/movies")
public class MoviesController {
	
	@GetMapping("/create")
	public String create() {
		return "movies/formMovies";
	}
	
	@PostMapping("/save")
	public String save(Movie movie, BindingResult result) {	
		
//		if (result.hasErrors()) {
//			System.out.println("Existieron errores" + result);
//			return "movies/formMovies";
//		}
		
		for(ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage());
		}
		
		System.out.println("Recibiendo obj película: " + movie);
		return "movies/formMovies";
	}
}
