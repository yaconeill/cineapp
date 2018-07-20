package net.yaco.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.yaco.app.model.Banner;
import net.yaco.app.service.IBannersService;
import net.yaco.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannersController {

	// Ejercicio: Inyectar instancia de la clase de servicio
	@Autowired
	private IBannersService serviceBanner;
		
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Banner> list = serviceBanner.searchAll();
		model.addAttribute("banners", list);
		return "redirect:/banners/indexPaginate";
	}
	
	/**
	 * Metodo para mostrar el formulario para crear un nuevo Banner
	 * @return
	 */
	@GetMapping("/create")
	public String create(@ModelAttribute Banner banner) {
		return "banners/formBanner";
		
	}
	
	/**
	 * Metodo para guardar el objeto de modelo de tipo Banner
	 * @return
	 */
	@PostMapping("/save")
	public String save(Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("imageFile") MultipartFile multiPart, HttpServletRequest request) {
		
		// Ejercicio: Implementar el metodo.

		if (result.hasErrors()) {
			//System.out.println("Existieron errores" + result);
			return "banners/formbanner";
		}
		
		if (!multiPart.isEmpty()) {
			String imageName = Utileria.saveImage(multiPart, request);
			banner.setFile(imageName);
		}
		
		serviceBanner.insert(banner);
		attributes.addFlashAttribute("message", "Registro guardado correctamente");
		
		return "redirect:/banners/indexPaginate";
	}	
	
	/**
	 * Metodo que muestra el formulario para editar una pelicula
	 * @param idMovie
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	private String edit(@PathVariable("id") int idBanner, Model model) {
		Banner banner = serviceBanner.searchId(idBanner);
		model.addAttribute("banner", banner);
		return "banners/formBanner";
	}

	/**
	 * Metodo para eliminar una pelicula
	 * @param idMovie
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	private String delete(@PathVariable("id") int idBanner, RedirectAttributes attributes) {
		// Delete banner
		serviceBanner.delete(idBanner);

		attributes.addFlashAttribute("message", "El bannerfue eliminado");

		return "redirect:/banners/indexPaginate";
	}

	
	/**
	 * Metodo que muestra la lista de banners con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String showPaginatedIndex(Model model, Pageable page) {
		Page<Banner> list = serviceBanner.searchAll(page);
		model.addAttribute("banners", list);
		return "banners/bannerList";
	}
}
