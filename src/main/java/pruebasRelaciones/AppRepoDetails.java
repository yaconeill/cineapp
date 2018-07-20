package pruebasRelaciones;

import java.util.List;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Detail;
import net.yaco.app.repository.DetailsRepository;
import net.yaco.app.util.Utileria;

public class AppRepoDetails {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		DetailsRepository repo = context.getBean("detailsRepository", DetailsRepository.class);

		List<Detail> list = repo.findAll();

		for (Detail d : list) {
			System.out.println(Utileria.toString(d.getId(),new String[]{ d.getDirector(), d.getActors()}));
		}

		context.close();
	}

}
