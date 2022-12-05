package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SearchMovieController {

    @FXML
    private TextField search_movie_genre;

    @FXML
    private TextField search_movie_name;

    @FXML
    private Button search_movie_genre_button;

    @FXML
    private Button search_movie_name_button;
    
    private TextField movieName;

    @FXML
    void search_movie_by_name(ActionEvent eventforsearchingbyname) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
    	String line = reader.readLine();
    	String searchName = movieName.getText();
    	String[] searchWords = searchName.split(" ");
    	
    	while (line != null) {
    		String nameInFile = line.split("%%%")[0];
    		String[] words = nameInFile.split(" ");
    		
    		ArrayList<Movie> matches = new ArrayList<Movie>();
    		for (String aword: words) {
    			for (String searchword: searchWords) { 
//    				if (aword.equals(searchword)) {
//    					matches.add(new Movie(nameInFile, line.split("%%%")[1].split(" "), Integer.parseInt(line.split("%%%")[2]), Double.parseDouble(line.split("%%%")[3]))
//    				}
    				break;
    			}
    		}
    		
    	}
    }

    @FXML
    void search_movie_by_genre(ActionEvent eventforsearchingbygenre) {

    }
    
    
    // add a setter and private value in previous controller as well
    public void setMovieName(TextField value) {
    	movieName = value;
    }

}