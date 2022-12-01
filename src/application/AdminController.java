package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private Button add_movie_button;

    @FXML
    private TextField admin_movie_genre;

    @FXML
    private TextField admin_movie_base_price;

    @FXML
    private TextField admin_movie_name;

    @FXML
    private TextField admin_movie_len;
    
    @FXML
    private TextField admin_movie_rating;

    @FXML
    private TextField admin_theatre;

    private Stage applicationStage;
    
    private Scene myScene;
    
    private MovieTicketController nextController;

    @FXML
    void add_the_movie(ActionEvent event) throws IOException {
    
	    String movieName = admin_movie_name.getText();
	    String movieGenre = admin_movie_genre.getText();
	    String movieLen = (String) admin_movie_len.getText();
	    String moviePrice = (String) admin_movie_base_price.getText();
	    String movieTheatre = admin_theatre.getText();
	    String movie_rating = admin_movie_rating.getText();
	    
	    String specialChar = "%%%";
	    
	    String movie_representaion = movieName + specialChar + movieTheatre + specialChar + movie_rating + specialChar + movieLen + specialChar + moviePrice + specialChar + movieGenre;
	    	
	    BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/ListOfMovies.txt", true));
	    writer.write(movie_representaion + "\n");
	    
	    writer.close();
	    
	    nextController.changethescene();
	    
    }
    
    void setMyScene(Scene ascene) {
    	myScene = ascene;
    }

	public void setPrimaryStage(Stage astage) {
		applicationStage = astage;		
	}

	public void setNextController(MovieTicketController acontroller) {
		nextController = acontroller;
	}
	
	void changethescene() {
		applicationStage.setScene(myScene);
	}
}
