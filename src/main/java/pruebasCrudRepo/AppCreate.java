package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppCreate {

	public static void main(String[] args) {
		
		Article article = new Article();
		article.setTitle("Proximo Estreno: The Predator");
		article.setDetails("El mes de septiembre se estrena la nueva entrega de predator");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
		repo.save(article);
		
		context.close();

	}

}
