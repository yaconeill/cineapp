package net.yaco.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;

import net.yaco.app.model.Article;

//@Service
public class ArticlesServiceImpl implements IArticlesService{
	
	public ArticlesServiceImpl() {
	}

	@Override
	public void insert(Article article) {
		System.out.println(article);
	}

	@Override
	public List<Article> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findLastNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article searchById(int idArticle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Article> searchAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
}
