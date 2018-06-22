package net.yaco.app.model;

import java.util.Date;

public class Article {

	private int id;
	private String title;
	private Date date;
	private String details;
	private String status;
	
	public Article() {
		//System.out.println("Constructor noticia");
		this.date = new Date();
		this.status = "Active";
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

	public void setTitle(String title) {
		//System.out.println("Set titulo");
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		//System.out.println("Set detalle");
		this.details = details;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		//System.out.println("Set estatus");
		this.status = status;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", date=" + date + ", details=" + details + ", status="
				+ status + "]";
	}
	
	
}
