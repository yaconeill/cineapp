/**
 * Clase que representa una imagen del Banner (Carousel) de la pagina principal
 */
package net.yaco.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Banners")
public class Banner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private Date date; // Date de Publicacion del Banner
	private String file; // atributo para guardar el nombre de la imagen
	private String status;

	/**
	 * Constructor de la clase
	 */
	public Banner() {
		this.date = new Date(); // Por default, la Date del sistema
		this.status = "Active"; // Por default el banner esta activo
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String Title) {
		this.title = Title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date Date) {
		this.date = Date;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String File) {
		this.file = File;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String Status) {
		this.status = Status;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", Title=" + title + ", Date=" + date + ", File=" + file + ", Status="
				+ status + "]";
	}

}
