package net.yaco.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.yaco.app.model.Banner;

public interface IBannersService {

	void insert(Banner banner);
	void delete(int idBanner);
	List<Banner> searchAll();
	List<Banner> searchAllActive();
	Banner searchId(int idBanner);
	Page<Banner> searchAll(Pageable page);
}
