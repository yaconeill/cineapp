package net.yaco.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;

import net.yaco.app.model.Banner;

//@Service
public class BannersServiceImpl implements IBannersService {

	private List<Banner> list = null;

	/**
	 * En el constructor creamos una lista enlazada con objetos de tipo Banner
	 */
	public BannersServiceImpl() {
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		// Ejercicio: Crear una nueva lista enlazada

		// Ejercicio: Crear algunos objetos de tipo Banner (estaticos)

		// Ejercicio: Agregar los objetos Banner a la lista

		list = new LinkedList<>();

		Banner banner1 = new Banner();
		banner1.setId(0);
		banner1.setTitle("Primero");
		banner1.setFile("slide1.jpg");

		Banner banner2 = new Banner();
		banner2.setId(1);
		banner2.setTitle("Segundo");
		banner2.setFile("slide2.jpg");

		Banner banner3 = new Banner();
		banner3.setId(2);
		banner3.setTitle("Tercero");
		banner3.setFile("slide3.jpg");

		Banner banner4 = new Banner();
		banner4.setId(3);
		banner4.setTitle("Cuarto");
		banner4.setFile("slide4.jpg");

		list.add(banner1);
		list.add(banner2);
		list.add(banner3);
		list.add(banner4);

	}

	/**
	 * Insertamos un objeto de tipo Banner a la lista
	 */
	@Override
	public void insert(Banner banner) {

		// Ejercicio: Implementar metodo
		list.add(banner);
	}

	/**
	 * Regresamos la lista de objetos Banner
	 */
	@Override
	public List<Banner> searchAll() {

		// Ejercicio: Implementar metodo
		return list;

	}

	@Override
	public Banner searchId(int idBanner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Banner> searchAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int idBanner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Banner> searchAllActive() {
		// TODO Auto-generated method stub
		return null;
	}

}
