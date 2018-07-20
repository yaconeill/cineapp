package net.yaco.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.yaco.app.model.Movie;
import net.yaco.app.service.IDetailsService;
import net.yaco.app.service.IMoviesService;
import net.yaco.app.util.Utileria;

@Controller
@RequestMapping("/movies")
public class MoviesController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IDetailsService serviceDetails;

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private IMoviesService serviceMovies;

	/**
	 * Metodo que muestra la lista de peliculas
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Movie> list = serviceMovies.searchAll();
		model.addAttribute("movies", list);
		return "redirect:/movies/indexPaginate";
	}

	/**
	 * Metodo que muestra la lista de peliculas con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String showPaginatedIndex(Model model, Pageable page) {
		Page<Movie> list = serviceMovies.searchAll(page);
		model.addAttribute("movies", list);
		return "movies/movieList";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear una pelicula
	 * @param movie
	 * @param model
	 * @return
	 */
	@GetMapping("/create")
	public String create(@ModelAttribute Movie movie, Model model) {
		return "movies/formMovies";
	}

	/**
	 * Metodo para guardar los datos de la pelicula (CON ARCHIVO DE IMAGEN)
	 * @param movie
	 * @param result
	 * @param attributes
	 * @param multiPart
	 * @param request
	 * @return
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute Movie movie, BindingResult result, RedirectAttributes attributes,
			@RequestParam("imageFile") MultipartFile multiPart, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("Existieron errores" + result);
			return "movies/formMovies";
		}

		if (!multiPart.isEmpty()) {
			String imageName = Utileria.saveImage(multiPart, request);
			movie.setImage(imageName);
		}

		serviceDetails.insert(movie.getDetail());
		serviceMovies.insert(movie);
		attributes.addFlashAttribute("message", "Registro guardado correctamente");

		return "redirect:/movies/indexPaginate";
	}

	
	/**
	 * Metodo que muestra el formulario para editar una pelicula
	 * @param idMovie
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	private String edit(@PathVariable("id") int idMovie, Model model) {
		Movie movie = serviceMovies.searchId(idMovie);
		model.addAttribute("movie", movie);
		return "movies/formMovies";
	}

	/**
	 * Metodo para eliminar una pelicula
	 * @param idMovie
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	private String delete(@PathVariable("id") int idMovie, RedirectAttributes attributes) {
		Movie movie = serviceMovies.searchId(idMovie);

		// Delete movie first
		serviceMovies.delete(idMovie);

		// Then delete movie details
		serviceDetails.delete(movie.getDetail().getId());
		attributes.addFlashAttribute("message", "La película fue eliminada");
		return "redirect:/movies/indexPaginate";
	}

	/**
	 * Agregamos al Model la lista de Generos: De esta forma nos evitamos agregarlos en los metodos
	 * @return
	 */
	@ModelAttribute("genres")
	public List<String> getGenre() {
		return serviceMovies.searchGenre();
	}

	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
