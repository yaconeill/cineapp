package net.yaco.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.yaco.app.model.Article;

public interface IArticlesService {
	
	void insert(Article article);
	List<Article> searchAll();
	List<Article> findLastNews();
	void delete(int idArticle);
	Article searchById(int idArticle);
	Page<Article> searchAll(Pageable page);

}
