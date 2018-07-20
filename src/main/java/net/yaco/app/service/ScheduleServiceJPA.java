package net.yaco.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.yaco.app.model.Schedule;
import net.yaco.app.repository.SchedulesRepository;

@Service
public class ScheduleServiceJPA implements IScheduleService{
	
	@Autowired
	private SchedulesRepository scheduleRepo;

	@Override
	public List<Schedule> searchByIdMovie(int idMovie, Date date) {
		return scheduleRepo.findByMovie_IdAndDateOrderByHour(idMovie, date);
	}

	@Override
	public void insert(Schedule schedule) {
		scheduleRepo.save(schedule);
	}

	@Override
	public List<Schedule> searchAll() {
		return scheduleRepo.findAll();
	}

	@Override
	public Page<Schedule> searchAll(Pageable page) {
		return scheduleRepo.findAll(page);
	}

	@Override
	public void delete(int idSchedule) {
		scheduleRepo.deleteById(idSchedule);		
	}

	@Override
	public Schedule searchById(int idSchedule) {
		Optional<Schedule> opt = scheduleRepo.findById(idSchedule);
		if (opt.isPresent()) 
			return opt.get();
		return null;
	}

}
