package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.repository.NewsRepository;

public class AppExist {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		int articleId =1;
		System.out.println(repo.existsById(articleId));

		context.close();

	}

}
