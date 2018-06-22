package net.yaco.app.service;

import org.springframework.stereotype.Service;

import net.yaco.app.model.Article;

@Service
public class ArticlesServiceImpl implements IArticlesService{
	
	public ArticlesServiceImpl() {
	}

	@Override
	public void save(Article article) {
		System.out.println(article);
	}
}
