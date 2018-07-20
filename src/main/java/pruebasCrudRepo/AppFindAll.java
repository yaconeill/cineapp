package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppFindAll {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		Iterable<Article> it = repo.findAll();
		for(Article n : it) {
			System.out.println(n);
		}

		context.close();

	}

}
