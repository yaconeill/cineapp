package pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Banner;
import net.yaco.app.repository.BannersRepository;
import net.yaco.app.util.Utileria;

public class AppFindAllBanners {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		BannersRepository repo = context.getBean("bannersRepository", BannersRepository.class);
		List<Banner> list = repo.findAll();
		System.out.println("\n");
		for (Banner m : list) {
			System.out.println( Utileria.toString(m.getId(), new String[]{ m.getStatus(), m.getTitle(), m.getFile()}));
			//System.out.println( Utileria.addZero(m.getId()) + " - " + m.getStatus() + " - " + m.getTitle() + " - " + d.getDirector() + " - " + d.getActors());
		}
		
		context.close();
	}
}
