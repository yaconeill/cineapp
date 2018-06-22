package net.yaco.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String save(Article article) {
		// Pendiente: Guardar obj en BD
		
		serviceArticles.save(article);
		return "news/formNoticia";
	}
}
