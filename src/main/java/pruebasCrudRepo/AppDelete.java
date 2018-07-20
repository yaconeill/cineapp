package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.repository.NewsRepository;

public class AppDelete {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		int articleId =2;
		//repo.deleteById(articleId);
		
		if(repo.existsById(articleId)) {
			repo.deleteById(articleId);
		}
		//System.out.println(repo.existsById(articleId));

		context.close();

	}

}
