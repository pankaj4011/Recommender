package com.movie.recommender.dto;

public class Movie {
	private String id = null;
	private String title = null;
	private int year;
	private String geners = null;
	private String director = null;
	private String country = null;
	private int minutes;
	private String poster = null;

	public Movie(String id, String title, int year, String geners, String director, String country, int minutes,
			String poster) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.geners = geners;
		this.director = director;
		this.country = country;
		this.minutes = minutes;
		this.poster = poster;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getGeners() {
		return geners;
	}

	public void setGeners(String geners) {
		this.geners = geners;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", geners=" + geners + ", director="
				+ director + ", country=" + country + ", minutes=" + minutes + ", poster=" + poster + "]";
	}

}
