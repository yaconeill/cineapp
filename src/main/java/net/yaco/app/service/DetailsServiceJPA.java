package net.yaco.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.yaco.app.model.Detail;
import net.yaco.app.repository.DetailsRepository;

@Service
public class DetailsServiceJPA implements IDetailsService{
	
	@Autowired
	private DetailsRepository detailsRepo;

	public void insert(Detail detail) {
		detailsRepo.save(detail);
	}

	@Override
	public void delete(int idDetail) {
		detailsRepo.deleteById(idDetail);
	}

}
