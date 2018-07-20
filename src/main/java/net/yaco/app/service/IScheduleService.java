package net.yaco.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.yaco.app.model.Schedule;

public interface IScheduleService {
	List<Schedule> searchByIdMovie(int idMovie, Date date);
	void insert(Schedule schedule);
	List<Schedule> searchAll();
	Page<Schedule> searchAll(Pageable page);
	void delete(int idSchedule);
	Schedule searchById(int idSchedule);
}
