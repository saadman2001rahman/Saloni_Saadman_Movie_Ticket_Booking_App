package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends Person{
//	private String username;
	
	Admin(String aname) {
		super(aname);
	}
	
//	public String getUsername() {
//		return username;
//	}
	
	public void addMovie(Movie amovie) throws IOException {
		String specialChar = "%%%";
	    String movie_representaion = amovie.getMovieName() + specialChar + amovie.getTheatreName() + specialChar + amovie.getRating() + specialChar + amovie.getLen() + specialChar + amovie.getbasePrice() + specialChar + amovie.getGenres();
		BufferedWriter writer = new BufferedWriter(new FileWriter("ListOfMovies.txt", true));
		writer.write(movie_representaion);
		writer.close();
	}

}
