package pruebasCrudRepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppRead {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
		
		Optional<Article> article = repo.findById(1);
		System.out.println(article.get());

		context.close();

	}

}
