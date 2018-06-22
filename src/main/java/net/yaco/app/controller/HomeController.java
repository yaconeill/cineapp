package net.yaco.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.yaco.app.model.Movie;
import net.yaco.app.service.IMoviesService;
import net.yaco.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IMoviesService serviceMovies;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@GetMapping(value = "/home")
	public String goHome() {
		return "home";
	}
	
	@PostMapping(value = "/search")
	public String search(@RequestParam("fecha") String date, Model model) {
		
		List<String> dateList = Utileria.getNextDate(4);
		List<Movie> movies = serviceMovies.searchAll();
		
		model.addAttribute("dates", dateList);
		model.addAttribute("searchDate", date);
		model.addAttribute("movies", movies);
		return "home";
	}
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		List<String> dateList = Utileria.getNextDate(4);
		List<Movie> movies = serviceMovies.searchAll();
		model.addAttribute("dates", dateList);
		model.addAttribute("searchDate", dateFormat.format(new Date()));
		model.addAttribute("movies", movies);
		
		return "home";
	}

	@GetMapping(value = "/detail")
	public String showDetail(Model model, @RequestParam("idMovie") int idMovie, @RequestParam("date") String date) {
		
		System.out.println("Id película: " + idMovie + " Fecha: " + date);
		model.addAttribute("movie", serviceMovies.searchId(idMovie));
		
		// TODO - get schedules from DB
		return "detail";
	}
	
}
