package pruebasQuery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Article;
import net.yaco.app.repository.NewsRepository;

public class AppKeywordFindBy {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
		// Ejemplo Keyword Find By
		
		//List<Article> list = repo.findByStatus("inactive");

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Article> list = null;
		try {
			list = repo.findByDate(format.parse("2017-09-01"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Article n : list) {
			System.out.println(n.getId() + "  - " + n.getDate() + " - " + n.getTitle());
		}
		
		context.close();

	}

}
