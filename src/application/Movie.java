package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Movie {
	
	private String movieName;
	private final String[] movieGenre;
	private int movieLengthMin;
	private double basePrice;
	private String theatre;
	private String movieRating;
	
//	public Movie (String mName, String[] mGenre, int mLen, double basePrice, Show show) {
//		super(show);
//		this.movieName = mName;
//		this.movieGenre = mGenre;
//		this.movieLengthMin = mLen;
//		this.basePrice= basePrice;
//		
//	}
	
	//this is a seperate constrcutor for testing purposes
	public Movie (String mName, String[] mGenre, int mLen, double price, String atheatre, String rate) {
		movieName = mName;
		movieGenre = mGenre;
		movieLengthMin = mLen;
		basePrice= price;
		theatre = atheatre;
		movieRating = rate;
	}
	
	public Movie (String mName) {
		movieName = mName;
		movieGenre = new String[5];
		movieLengthMin = 0;
		basePrice= 0.0;
		theatre = "";
		movieRating = "";
	}
	
	
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
	
	public Movie getMovieFromGenre(String[] mGenre) {
		if (movieGenreMatch(this.movieGenre, mGenre)) {
			return this;
		}
		
		else {
			return null;
		}
	}

	public double getbasePrice() {
		return this.basePrice;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public String getTheatreName() {
		return theatre;
	}
	
	public String getGenres() {
		String result = "";
		for (String n: movieGenre) {
			result += n + " ";
		}
		return result;
	}
	
	public String getLen() {
		return Integer.toString(movieLengthMin);
	}
	
	public String getRating() {
		return movieRating;
	}
	
}
