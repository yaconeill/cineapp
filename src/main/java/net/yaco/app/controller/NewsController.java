package net.yaco.app.controller;

import java.util.List;


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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.yaco.app.model.Article;
import net.yaco.app.service.IArticlesService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private IArticlesService serviceArticles;
	
	/**
	 * Metodo para mostrar el listado de banners
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/index")
	public String showIndex(Model model) {
		List<Article> list = serviceArticles.searchAll();
		model.addAttribute("news", list);
		return "redirect:/news/indexPaginate";
	}
	
	@GetMapping(value = "/create")
	public String create(@ModelAttribute Article article, Model model) {
		return "news/formNoticia";
	}
	
	@PostMapping(value = "/save")
	public String save(@ModelAttribute Article article, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("Existieron errores" + result);
			return "news/formNoticia";
		}		
		serviceArticles.insert(article);
		attributes.addFlashAttribute("message", "Registro guardado correctamente");
		return "redirect:/news/indexPaginate";
	}	

	/**
	 * Metodo que muestra el formulario para editar una noticia
	 * @param idMovie
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/edit/{id}")
	private String edit(@PathVariable("id") int idArticle, Model model) {
		Article article  = serviceArticles.searchById(idArticle);
		model.addAttribute("article", article);
		return "news/formNoticia";
	}

	/**
	 * Metodo para eliminar una noticia
	 * @param idMovie
	 * @param attributes
	 * @return
	 */
	@GetMapping(value = "/delete/{id}")
	private String delete(@PathVariable("id") int idArticle, RedirectAttributes attributes) {
		// Delete article
		serviceArticles.delete(idArticle);
		attributes.addFlashAttribute("message", "La noticia fue eliminada");

		return "redirect:/news/indexPaginate";
	}
	
	/**
	 * Metodo que muestra la lista de peliculas con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String showPaginatedIndex(Model model, Pageable page) {
		Page<Article> list = serviceArticles.searchAll(page);
		model.addAttribute("news", list);
		return "news/newsList";
	}
	
}
