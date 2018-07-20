package pruebasJpaRepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppSorting {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		//List<Article> list = repo.findAll(Sort.by("title").descending());
		
		List<Article> list = repo.findAll(Sort.by("title").ascending().and(Sort.by("date").descending()));
		for(Article n : list) {
			System.out.println(n.getDate() + " - " + n.getTitle());
		}

		context.close();

	}

}
