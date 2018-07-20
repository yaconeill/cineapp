package net.yaco.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.yaco.app.model.Contact;
import net.yaco.app.service.IMoviesService;

@Controller
public class ContactController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	IMoviesService serviceMovies;
	
	/**
	 * Metodo para mostrar el formulario de contacto
	 * @param contact
	 * @param model
	 * @return
	 */
	@GetMapping("/contact")
	public String showForm(@ModelAttribute("contact") Contact contact) {
		return "formContact";
	}
	
	/**
	 * Metodo para guardar los datos del formulario de contacto
	 * @param contact
	 * @return
	 */
	@PostMapping("/contact")
	public String save(@ModelAttribute Contact contact, RedirectAttributes attributes) {
		attributes.addFlashAttribute("msg", "Gracias por enviarnos tu opinion!.");
		return "redirect:/contact";
	}
	
	@ModelAttribute("genre")
	public List<String> getGenres(){
		return serviceMovies.searchGenre();
	}
}
