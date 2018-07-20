package net.yaco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

@Service
public class ArticleServiceJPA implements IArticlesService{

	@Autowired
	private NewsRepository newsRepo;
	
	@Override
	public void insert(Article article) {
		newsRepo.save(article);
	}

	@Override
	public List<Article> searchAll() {
		return newsRepo.findAll();
	}

	@Override
	public Page<Article> searchAll(Pageable page) {
		return newsRepo.findAll(page);
	}

	@Override
	public List<Article> findLastNews() {		
		return newsRepo.findTop3ByStatusOrderByIdDesc("Active");
	}

	@Override
	public void delete(int idArticle) {
		newsRepo.deleteById(idArticle);		
	}

	@Override
	public Article searchById(int idArticle) {
		Optional<Article> opt = newsRepo.findById(idArticle);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

}
