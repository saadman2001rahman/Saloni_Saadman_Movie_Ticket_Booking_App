package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Movie {
	
	private String movieName = "";
	private final String[] movieGenre;
	private int movieLengthMin;
	private Theater theater;
	private String movieRating;
	private double basePrice;
	
	/**
	 * Construct a movie with a name, list of genres associated with the movie, base price and a selected theatre that the movie plays in.
	 * @param mName
	 * @param mGenre
	 * @param mLen
	 * @param basePrice
	 * @param mTheatre
	 */
	public Movie (String mName, String[] mGenre, int mLen, double basePrice, Theater mTheatre) {
		this.movieName = mName;
		this.movieGenre = mGenre;
		this.movieLengthMin = mLen;
		this.basePrice= basePrice;
		theater = mTheatre;
	}
	
	/**
	 * 
	 * @return movieName
	 */
	public String getMovieName() {
		return this.movieName;
	}
		
	/**
	 * Check if the selected list of movie genres matches the movie genres and return true if they do
	 * @param movieGenre
	 * @param selectedGenre
	 * @return Boolean
	 */
	public Boolean movieGenreMatch(String[] movieGenre, String[] selectedGenre) {
		int counter = 0;
		if(Arrays.equals(movieGenre, selectedGenre)) {
			return true;
		}
		for(String genre: selectedGenre) {
			for(String sGenre : movieGenre) {
				if(Objects.equals(genre, sGenre)){
					counter ++;
					break;
				}
			}
		}
		return counter == selectedGenre.length;
	}
	
	/**
	 * Return the movie that matches the list of preferred genres a customer may want to watch
	 * @param mGenre
	 * @return
	 */
	public Movie getMovieFromGenre(String[] mGenre) {
		if (movieGenreMatch(this.movieGenre, mGenre)) {
			return this;
		}
		
		else {
			return null;
		}
	}

	/**
	 * 
	 * @return movie basePrice
	 */
	public double getbasePrice() {
		return this.basePrice;
	}
	
	/**
	 * link the movie to play in a particular theater
	 * @param theater
	 */
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
//	public void addTheater(Theater theater) {
//		this.theater.add(theater);
//	}
	
	/**
	 * 
	 * @return theater type
	 */
	public String getTheaterType() {
		return theater.getType();
	}
	
	/**
	 * 
	 * @return theater number
	 */
	public int getTheatreNumber() {
		return theater.getTheaterNum();
	}
	
//	public String gettheatre() {
//		String res = "";
//		for (String aTheater: theaters) {
//			res += aTheater + " ";
//		}
//		
//		return res;
//	}

	/**
	 * 
	 * @return movie genres 
	 */
	public String getGenres() {
		String result = "";
		for (String n: movieGenre) {
			result += n + " ";
		}
		return result;
	}
	
	/**
	 * 
	 * @return movieLength
	 */
	public String getLen() {
		return Integer.toString(movieLengthMin);
	}
	
	/**
	 * 
	 * @return movieRating
	 */
	public String getRating() {
		return movieRating;
	}


}
