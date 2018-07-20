package net.yaco.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.yaco.app.model.Banner;
import net.yaco.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService {
	
	@Autowired
	private BannersRepository bannersRepo;

	@Override
	public void insert(Banner banner) {
		bannersRepo.save(banner);		
	}	

	@Override
	public List<Banner> searchAllActive() {
		return bannersRepo.findByStatusOrderByIdDesc("Active");
	}

	@Override
	public void delete(int idBanner) {
		bannersRepo.deleteById(idBanner);
	}

	@Override
	public List<Banner> searchAll() {
		return bannersRepo.findAll();
	}
	
	@Override
	public Banner searchId(int idBanner) {		
		Optional<Banner> opt = bannersRepo.findById(idBanner);
		if (opt.isPresent())
			return opt.get();
		return null;
	}

	@Override
	public Page<Banner> searchAll(Pageable page) {
		return bannersRepo.findAll(page);
	}

}
