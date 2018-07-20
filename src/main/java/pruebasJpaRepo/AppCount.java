package pruebasJpaRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.repository.NewsRepository;

public class AppCount {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NewsRepository repo = context.getBean("newsRepository", NewsRepository.class);
				
		long num = repo.count();
		System.out.println("nº reg: " + num);

		context.close();

	}

}
