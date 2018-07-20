package pruebasJpaRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppPaging {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		
		// Page<Article> page = repo.findAll(PageRequest.of(2, 10));
		
		Page<Article> page = repo.findAll(PageRequest.of(0, 10, Sort.by("title").descending()));
		
		for(Article n : page) {
			System.out.println(n.getId() + "  - " + n.getDate() + " - " + n.getTitle());
		}

		context.close();

	}

}
