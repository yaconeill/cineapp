package pruebasRelaciones;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.ParseException;

import net.yaco.app.model.Movie;
import net.yaco.app.model.Schedule;
import net.yaco.app.repository.SchedulesRepository;
import net.yaco.app.util.Utileria;

public class AppRepoSchedules {

	public static void main(String[] args) throws java.text.ParseException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		SchedulesRepository repo = context.getBean("schedulesRepository", SchedulesRepository.class);

		List<Schedule> list = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2018-7-15";
		try {

            Date date = formatter.parse(dateInString);
    		list = repo.findByDate(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
		

		//System.out.println("Nº de entidades: " + list.size());
		for (Schedule s : list) {
			Movie m = s.getMovie();
			System.out.println(Utileria.toString(s.getId(), new String[]{ s.getCinemaRoom(), m.getTitle(), s.getPrice().toString()}));
		}

		context.close();
	}

}
