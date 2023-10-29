package com.movie.recommender;

import com.movie.recommender.dto.Movie;
import com.movie.recommender.dto.Rating;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class MovieRunnerAverage {

	private static SecondRatings secondRatings;

	public static void printAverageRatings() {
		String moviesPath = "C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratedmovies_short.csv";
		String ratingsPath = "C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratings_short.csv";
		ArrayList<Rating> averageMovieRating;
		secondRatings = new SecondRatings(moviesPath, ratingsPath);
		System.out.println(secondRatings.getMovieSize());
		System.out.println(secondRatings.getRaterSize());
		averageMovieRating = secondRatings.getAverageRatings(3);
		//add logic to sort the list
//averageMovieRating=(ArrayList<Rating>) averageMovieRating.stream().sorted().collect(Collectors.toList());
	
		for (Rating rating : averageMovieRating) {
			System.out.println(rating.getValue() + " " + secondRatings.getTitle(rating.getItem()));
		}
	}
	
	public static void getAverageRatingOneMovie() {
		String moviesPath = "C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratedmovies_short.csv";
		String ratingsPath = "C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratings_short.csv";
		secondRatings = new SecondRatings(moviesPath, ratingsPath);

	}

	public static void main(String[] args) {
		printAverageRatings();
	}

}

