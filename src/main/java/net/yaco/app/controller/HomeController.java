package net.yaco.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.yaco.app.model.Article;
import net.yaco.app.model.Banner;
import net.yaco.app.model.Movie;
import net.yaco.app.model.Schedule;
import net.yaco.app.service.IArticlesService;
import net.yaco.app.service.IBannersService;
import net.yaco.app.service.IMoviesService;
import net.yaco.app.service.IScheduleService;
import net.yaco.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IBannersService serviceBanner;
	
	@Autowired
	private IMoviesService serviceMovies;
	
	@Autowired
	private IScheduleService servicesSchedule;

	@Autowired
	private IArticlesService servicesArticle;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	/**
	 * Metodo para mostrar la pagina principal de la aplicacion
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/")
	public String showHome(Model model) {		
		try {
			Date noDate = dateFormat.parse(dateFormat.format(new Date())); 
			List<String> dateList = Utileria.getNextDate(4);
			List<Movie> movies = serviceMovies.searchByDate(noDate);
			model.addAttribute("dates", dateList);
			model.addAttribute("searchDate", dateFormat.format(new Date()));
			model.addAttribute("movies", movies);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}		
		return "home";
	}

	/**
	 * Metodo para filtrar las peliculas por fecha
	 * @param date
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/search")
	public String search(@RequestParam("date") Date date, Model model) {
		try {
			Date noDate = dateFormat.parse(dateFormat.format(date));
			List<String> dateList = Utileria.getNextDate(4);
			List<Movie> movies = serviceMovies.searchByDate(noDate);
			model.addAttribute("dates", dateList);
			model.addAttribute("searchDate", dateFormat.format(date));
			model.addAttribute("movies", movies);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.search" + e.getMessage());
		}		
		return "home";
	}

	/**
	 * Metodo para ver los detalles y horarios de una pelicula
	 * @param idMovie
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/detail")
	public String showDetail(Model model, @RequestParam("idMovie") int idMovie, @RequestParam("date") Date date) {
		
		List<Schedule> schedule = servicesSchedule.searchByIdMovie(idMovie, date);
		model.addAttribute("schedules", schedule);
		model.addAttribute("searchDate", dateFormat.format(date));
		model.addAttribute("movie", serviceMovies.searchId(idMovie));		
		return "detail";
	}

	/**
	 * Metodo que muestra la vista de la pagina de Acerca
	 * @return
	 */
	@GetMapping(value = "/about")
	public String showAbout() {
		return "about";
	}
	
	@GetMapping(value = "/formLogin")
	private String showLogin() {
		return "formLogin";
	}
	
	@ModelAttribute("news")
	public List<Article> getNews(){
		return servicesArticle.findLastNews();
	}
	
	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBanner.searchAll();
	}
	
	/**
	 * Metodo para personalizar el Data Binding para los atributos de tipo Date
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {				
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
