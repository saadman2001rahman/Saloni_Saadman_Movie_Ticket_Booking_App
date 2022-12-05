package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class Movie {
	
	private String movieName = "";
	private final String[] movieGenre;
	private int movieLengthMin;
	private ArrayList<Theater> theater;
	private String[] theaters;
	private String movieRating;
	private double basePrice;
	
	public Movie (String mName, String[] mGenre, int mLen, double basePrice, String[] mTheatres, String mrate) {
		this.movieName = mName;
		this.movieGenre = mGenre;
		this.movieLengthMin = mLen;
		this.basePrice= basePrice;
		this.movieRating = mrate;
		if (mTheatres.length == 0) {
			this.theaters = new String[10];
		} else {
			theaters = mTheatres;
		}
	}
	
	public String getMovieName() {
		return this.movieName;
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
	
	public void setTheater(ArrayList<Theater> theater) {
		this.theater = theater;
	}
	
	public void addTheater(Theater theater) {
		this.theater.add(theater);
	}
	
	public ArrayList<Theater> getTheaters() {
		return this.theater;
	}
	
	public String gettheatre() {
		String res = "";
		for (String aTheater: theaters) {
			res += aTheater + " ";
		}
		
		return res;
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
