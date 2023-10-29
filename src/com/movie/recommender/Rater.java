package com.movie.recommender;

import java.util.ArrayList;

import com.movie.recommender.dto.Rating;

public class Rater {
	private String myId = null;
	private ArrayList<Rating> myRatings;

	public Rater(String myId) {
		super();
		this.myId = myId;
		myRatings = new ArrayList<Rating>();
	}

	public void addRating(String item, double rating) {
		if (item != null) {
			myRatings.add(new Rating(item, rating));
		}
	}

	public String getId() {
		return myId;

	}

	public double getRating(String item) {
		for (Rating currentItem : myRatings) {
			if (currentItem.getItem().equalsIgnoreCase(item)) {
				return currentItem.getValue();
			}
		}
		return -1;
	}

	public boolean hasRating(String item) {
		for (Rating currentItem : myRatings) {
			if (currentItem.getItem().equalsIgnoreCase(item)) {
				return true;
			}
		}
		return false;
	}

	public int numRatings() {

		return myRatings.size();
	}

	public ArrayList<String> getItemsRated() {
		ArrayList<String> ratingList = new ArrayList<String>();
		for (Rating item : myRatings) {
			//System.out.println(getClass().getName()+"  "+item.getItem());
			ratingList.add(item.getItem());
		}
		return ratingList;
	}
}
