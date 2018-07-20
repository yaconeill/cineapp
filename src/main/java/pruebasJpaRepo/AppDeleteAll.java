package pruebasJpaRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.repository.NewsRepository;

public class AppDeleteAll {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);

		repo.deleteAllInBatch();
		
		context.close();

	}

}
