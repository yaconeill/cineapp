package pruebasRelaciones;

//import java.util.Date;
//import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import net.yaco.app.model.Detail;
//import net.yaco.app.model.Movie;
//import net.yaco.app.repository.MoviesRepository;
//import net.yaco.app.util.Utileria;

public class AppFindAllStatusDate {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");

//		MoviesRepository repo = context.getBean("moviesRepository", MoviesRepository.class);
//		@SuppressWarnings("deprecation")
//		Date date = new Date(2017, 9, 8);
//		List<Movie> list = repo.findAllByStatusAndDate("active", date);
		
//		System.out.println("\n");
		
//		for (Movie m : list) {
//			Detail d = m.getDetail();
//			System.out.println( Utileria.toString(m.getId(), new String[]{ m.getStatus(), m.getTitle(), d.getDirector(), d.getActors()}));
//		}
//		
		context.close();
	}
}
