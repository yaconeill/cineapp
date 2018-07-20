package pruebasCrudRepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppUpdate {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
		
		Optional<Article> optional = repo.findById(1);
		if(optional.isPresent()) {
			Article article = optional.get();
			article.setStatus("Inactive");
			repo.save(article);
		}

		context.close();

	}

}
