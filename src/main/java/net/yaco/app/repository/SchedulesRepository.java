package net.yaco.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.yaco.app.model.Schedule;

public interface SchedulesRepository extends JpaRepository<Schedule, Integer> {

	public List<Schedule> findByMovie_IdAndDateOrderByHour(int idMovie, Date date);
	
	/* mysql.cnf
	 *  [mysqld]
	 * 	sql_mode = "STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION" 
	 */
	@Query("select s from Schedule s where s.date = :date and movie.status='Active' group by s.movie order by movie.id asc")
	public List<Schedule> findByDate(@Param("date") Date date);
	
}
