package net.yaco.app.service;

import net.yaco.app.model.Detail;

public interface IDetailsService {
	void insert(Detail detail);
	void delete(int idDetail);
}
