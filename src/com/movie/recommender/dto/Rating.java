package com.movie.recommender.dto;

public class Rating {
	private String item = null;
	private double value;

	public Rating(String item, double value) {
		super();
		this.item = item;
		this.value = value;
	}

	public String getItem() {
		return item;
	}

	public double getValue() {
		return value;
	}

	public int compareTo(String anotherString) {
		return item.compareTo(anotherString);
	}

	@Override
	public String toString() {
		return "Rating [item=" + item + ", value=" + value + "]";
	}

}
