package pruebasRelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.yaco.app.model.Detail;
import net.yaco.app.model.Movie;
import net.yaco.app.repository.MoviesRepository;
import net.yaco.app.util.Utileria;

public class AppFindAll {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

		MoviesRepository repo = context.getBean("moviesRepository", MoviesRepository.class);
		List<Movie> list = repo.findAll();
		System.out.println("\n");
		for (Movie m : list) {
			Detail d = m.getDetail();
			System.out.println( Utileria.toString(m.getId(), new String[]{ m.getStatus(), m.getTitle(), d.getDirector(), d.getActors()}));
			//System.out.println( Utileria.addZero(m.getId()) + " - " + m.getStatus() + " - " + m.getTitle() + " - " + d.getDirector() + " - " + d.getActors());
		}
		
		context.close();
	}
}
