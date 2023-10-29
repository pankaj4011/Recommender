package com.movie.recommender;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import com.movie.recommender.dto.Movie;

public class FirstRatings {

	public static ArrayList<Movie> loadMovies(String fileName) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		File file = new File(fileName);
		try {

			CSVParser csvParser = CSVParser.parse(file, Charset.forName("utf-8"),
					CSVFormat.RFC4180.withFirstRecordAsHeader());
			for (CSVRecord record : csvParser) {

				String id = record.get("id");
				String title = record.get("title");
				String country = record.get("country");
				String genre = record.get("genre");
				String director = record.get("director");
				String poster = record.get("poster");
				int year = Integer.parseInt((String) record.get("year"));
				int minutes = Integer.parseInt(record.get("minutes"));

				movies.add(new Movie(id, title, year, genre, director, country, minutes, poster));
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return movies;

	}

	public static void testLoadMovies() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		list = loadMovies("C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratedmovies_short.csv");
		System.out.println("Number of movies:" + list.size());
		Map<String, Integer> directorMap = new HashMap<String, Integer>();
		int comedyCount = 0;
		int minuteCount = 0;
		String maxDirector = null;
		int maxDirectorCount = 0;
		for (Movie item : list) {
			if (item.getGeners().contains("Comedy")) {
				comedyCount++;
			}
			if (item.getMinutes() > 150) {
				minuteCount++;
			}
			List<String> directors = new ArrayList<String>();
			directors = Arrays.asList(item.getDirector().split(","));
			for (String dir : directors) {
				directorMap.put(dir.trim(), directorMap.getOrDefault(dir.trim(), 0) + 1);
			}

		}
		System.out.println("comedy movies: " + comedyCount);
		System.out.println("movies greater than 150 minutes: " + minuteCount);
		for (Map.Entry<String, Integer> map : directorMap.entrySet()) {
			System.out.println(map.getKey() + " : " + map.getValue());
			if (map.getValue() > maxDirectorCount) {
				maxDirector = map.getKey();
				maxDirectorCount = map.getValue();
			}

		}
		System.out.println("Max movies " + maxDirector + "  " + maxDirectorCount);
	}

	public static void main(String[] args) {
		// testLoadMovies();
		testLoadRaters();
	}

	public static ArrayList<Rater> loadRaters(String fileName) {
		File file = new File(fileName);
		ArrayList<Rater> raters = new ArrayList<Rater>();
		Rater newRater = null;
		String movieId =null;
		int flag = 0;
		try {

			CSVParser csvParser = CSVParser.parse(file, Charset.forName("utf-8"),
					CSVFormat.RFC4180.withFirstRecordAsHeader());
			for (CSVRecord record : csvParser) {
				String id = record.get("rater_id");
			    movieId = record.get("movie_id");
				double rating = Double.parseDouble(record.get("rating"));
				String time = record.get("time");
		
				if (raters.size() != 0) {

					for (Rater rater : raters) {

						if (rater.getId().equalsIgnoreCase(id)) {

							rater.addRating(movieId, rating);
							flag = 1;
							break;
						}

					}
					if (flag == 0) {

						newRater = new Rater(id);
						newRater.addRating(movieId, rating);
						raters.add(newRater);
					}
				} else {
					newRater = new Rater(id);
					newRater.addRating(movieId, rating);
					raters.add(newRater);
				}
				newRater = null;
				flag = 0;
			}
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		return raters;
	}

	public static void testLoadRaters() {
		ArrayList<Rater> raters = new ArrayList<Rater>();
		raters = loadRaters("C:\\personal\\coursera\\week1\\StepOneStarterProgram\\data\\ratings_short.csv");
		System.out.println("Total Raters: " + raters.size());
		ArrayList<String> itemsRated = new ArrayList<String>();
		Set<String> movies = new HashSet<String>();
		int movieRatingCount = 0;

		for (Rater r : raters) {
			itemsRated = r.getItemsRated();
			for (String item : itemsRated) {
				movies.add(item);
			}
		}
		System.out.println();
		System.out.println("Movies Rated: " + movies.size());

		// printing the number of movie ratings by movie id
		/*
		 * for (Rater r : raters) { itemsRated=r.getItemsRated(); for(String item:
		 * itemsRated) { if (item.equalsIgnoreCase("1798709")) { movieRatingCount++; } }
		 * } System.out.println("num of ratings "+movieRatingCount);
		 */

		// printing the maximum rating by any rater
		/*
		 * int maxRating = 0; String rater=null; for (Rater r : raters) {
		 * 
		 * if(r.numRatings()>maxRating) { rater=r.getId(); maxRating=r.numRatings(); } }
		 * System.out.println("Max Rater: "+rater+" Number of Ratings: "+maxRating);
		 */

		// printing the number rating by rater
		/*
		 * for(Rater r: raters) { if(r.getId().equals("193")) {
		 * System.out.println("number rating by rater "+r.numRatings()); } }
		 */
		/*
		 * printing raters and the movies rated for (Rater r : raters) {
		 * System.out.println("Rater's ID: " + r.getId() + " Rating's done: " +
		 * r.numRatings()); itemsRated = r.getItemsRated(); for (String item :
		 * itemsRated) {
		 * 
		 * System.out.println("Movie Id: "+item+"  Rating: "+r.getRating(item)); }
		 * System.out.println(); }
		 */
	}
}
