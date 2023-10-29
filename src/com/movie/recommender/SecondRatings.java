package com.movie.recommender;

import java.util.ArrayList;
import com.movie.recommender.dto.Movie;
import com.movie.recommender.dto.Rating;

public class SecondRatings {

	private ArrayList<Movie> myMovies;
	private ArrayList<Rater> myRaters;
	ArrayList<Rating> averageRatings;
	private FirstRatings firstRating;
	private Rating rating;

	public SecondRatings() {
	}

	public SecondRatings(ArrayList<Movie> myMovies, ArrayList<Rater> myRaters) {
		super();
		this.myMovies = myMovies;
		this.myRaters = myRaters;
	}

	public SecondRatings(String movieFile, String ratingsFile) {

		firstRating = new FirstRatings();
		myMovies = firstRating.loadMovies(movieFile);
		myRaters = firstRating.loadRaters(ratingsFile);
		

	}

	public int getMovieSize() {
		return myMovies.size();
	}

	public int getRaterSize() {
		return myRaters.size();
	}

	private double getAverageById(String id, int minimalRaters) {
		double rating = 0.0;
		ArrayList<String> itemsRated = new ArrayList<String>();
		int minCount = 0;
//System.out.println(id);
		for (Rater rater : myRaters) {
			itemsRated = rater.getItemsRated();
			
			for (String item : itemsRated) {
				//System.out.println("item "+item);
				if (item.equalsIgnoreCase(id)) {
					//System.out.println("here");
					minCount++;
					rating += rater.getRating(item);
				}
			}
		}
		//System.out.println(id + "  " + minCount);
		if (minCount >= minimalRaters) {
			return (rating / minCount);
		}
		return 0.0;
	}

	public ArrayList<Rating> getAverageRatings(int minimalRaters) {
		double averageRating = 0.0;
		Rating rating = null;
		averageRatings = new ArrayList<Rating>();
		for (Movie movie : myMovies) {
			// System.out.println(movie.getId()+" "+minimalRaters);
			averageRating = getAverageById(movie.getId(), minimalRaters);
			// System.out.println("averageRating "+averageRating);
			if (averageRating > 0.0) {
				rating = new Rating(movie.getId(), averageRating);
				averageRatings.add(rating);

			}
		}

		return averageRatings;
	}

	public String getTitle(String id) {
		for (Movie movie : myMovies) {
			if (movie.getId().equalsIgnoreCase(id)) {
				return movie.getTitle();
			}
		}
		return "Movie " + id + " not found.";
	}

	public String getId(String title) {
		for (Movie movie : myMovies) {
			if (movie.getTitle().equals(title)) {
				return movie.getId();
			}
		}
		return "NO SUCH TITLE";
	}

}
