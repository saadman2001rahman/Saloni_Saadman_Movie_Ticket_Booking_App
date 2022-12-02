package application;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Movie {
	
	private String movieName;
	private final String[] movieGenre;
	private int movieLengthMin;
	private double basePrice;
	private String theatre;
	
//	public Movie (String mName, String[] mGenre, int mLen, double basePrice, Show show) {
//		super(show);
//		this.movieName = mName;
//		this.movieGenre = mGenre;
//		this.movieLengthMin = mLen;
//		this.basePrice= basePrice;
//		
//	}
	
	//this is a seperate constrcutor for testing purposes
	public Movie (String mName, String[] mGenre, int mLen, double basePrice, String atheatre) {
		this.movieName = mName;
		this.movieGenre = mGenre;
		this.movieLengthMin = mLen;
		this.basePrice= basePrice;
		theatre = atheatre;
		
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
	
}
