package net.yaco.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.yaco.app.model.Article;
import net.yaco.app.service.IArticlesService;

@Controller
@RequestMapping("/noticias")
public class NewsController {
	
	@Autowired
	private IArticlesService serviceArticles;
	
	@GetMapping(value="/create")
	public String create() {
		return "news/formNoticia";
	}
	
	@PostMapping(value="/save")
	public String save(@RequestParam("titulo") String title, @RequestParam("estatus") String status, 
			@RequestParam("detalle") String details) {
		Article article = new Article();
		article.setTitle(title);
		article.setStatus(status);
		article.setDetails(details);
		
		// Pendiente: Guardar obj en BD
		
		serviceArticles.save(article);
		return "news/formNoticia";
	}
}
