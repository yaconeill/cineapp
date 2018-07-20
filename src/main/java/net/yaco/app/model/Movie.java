package net.yaco.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment MySQL
	private int id;
	private String title;
	private int duration;
	private String rating;
	private String genre;
	private String image = "cinema.png"; // Default image
	private Date releaseDate;
	private String status = "Active";
	
	//@Transient	// Ignore this attribute
	@OneToOne
	@JoinColumn(name = "detailId")
	private Detail detail;
	
//	@OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
//	private List<Schedule> schedules;

	public Movie() { }

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}	

//	public List<Schedule> getSchedules() {
//		return schedules;
//	}
//
//	public void setSchedules(List<Schedule> schedules) {
//		this.schedules = schedules;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", duration=" + duration + ", rating=" + rating + ", genre="
				+ genre + ", image=" + image + ", releaseDate=" + releaseDate + ", status=" + status + ", detail="
				+ detail + "]";
	}

}
