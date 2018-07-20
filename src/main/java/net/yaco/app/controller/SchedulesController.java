package net.yaco.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.yaco.app.model.Movie;
import net.yaco.app.model.Schedule;
import net.yaco.app.service.IMoviesService;
import net.yaco.app.service.IScheduleService;

@Controller
@RequestMapping(value="/schedules")
public class SchedulesController {
	
	@Autowired
	IScheduleService serviceSchedules;
	
	@Autowired
	IMoviesService serviceMovie;	

	/**
	 * Metodo que muestra la lista de los horarios
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/index")
	public String showIndex(Model model) {
		List<Schedule> list = serviceSchedules.searchAll();
		model.addAttribute("schedules", list);
		return "redirect:/schedules/indexPaginate";
	}

	/**
	 * Metodo que muestra la lista de peliculas con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String showPaginatedIndex(Model model, Pageable page) {
		Page<Schedule> list = serviceSchedules.searchAll(page);
		model.addAttribute("schedules", list);
		return "schedules/schedulesList";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo horario
	 * @return
	 */
	@GetMapping(value = "/create")
	public String create(@ModelAttribute Schedule schedule) {
		return "schedules/formSchedule";
	}
		
	/**
	 * Metodo para guardar el registro del Horario
	 * @param schedule
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/save")
	public String save(@ModelAttribute Schedule schedule, BindingResult result, RedirectAttributes attributes) {				
		
		if (result.hasErrors()) {			
			return "schedules/formSchedule";
		}	
		serviceSchedules.insert(schedule);
		attributes.addFlashAttribute("msg", "El horario fue guardado!");
		return "redirect:/schedules/indexPaginate";
	}

	/**
	 * Metodo que muestra el formulario para editar una noticia
	 * @param idSchedule
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	private String edit(@PathVariable("id") int idSchedule, Model model) {
		Schedule schedule = serviceSchedules.searchById(idSchedule);
		model.addAttribute("schedule", schedule);
		return "schedules/formSchedule";
	}

	/**
	 * Metodo para eliminar una noticia
	 * @param idSchedule
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	private String delete(@PathVariable("id") int idSchedule, RedirectAttributes attributes) {
		// Delete article
		serviceSchedules.delete(idSchedule);
		attributes.addFlashAttribute("message", "La noticia fue eliminada");
		return "redirect:/schedules/indexPaginate";
	}
	

	/**
	 * Agregamos al modelo, el listado de peliculas para que este disponible
	 * para todos los metodos de este controlador
	 * @return
	 */
	@ModelAttribute("movies")
	public List<Movie> getPeliculas(){
		return serviceMovie.searchAll();
	}
	

	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * @param binder
	 */
	@InitBinder("schedule")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
