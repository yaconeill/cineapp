package net.yaco.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Transient;

@Entity
@Table(name = "Schedules")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private String hour;	// HH:mm
	private String cinemaRoom;
	private Double price;
	
	//@Transient
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	
	public Schedule() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getCinemaRoom() {
		return cinemaRoom;
	}

	public void setCinemaRoom(String cinemaRoom) {
		this.cinemaRoom = cinemaRoom;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", date=" + date + ", hour=" + hour + ", cinemaRoom=" + cinemaRoom + ", price="
				+ price + ", movie=" + movie + "]";
	}	
	
}
