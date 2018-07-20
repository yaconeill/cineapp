package pruebasCrudRepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppFindAllById {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
		
		List<Integer> ids = new LinkedList<Integer>();
		ids.add(2);
		ids.add(5);
		ids.add(8);
		
		Iterable<Article> it = repo.findAllById(ids);
		for(Article n : it) {
			System.out.println(n);
		}

		context.close();

	}

}
