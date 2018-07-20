package pruebasJpaRepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppFindAll {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
//		List<Article> list = repo.findAll();
		List<Article> list = repo.findByStatus("Inactive");
		for(Article n : list) {
			System.out.println(n);
		}

		context.close();

	}

}
