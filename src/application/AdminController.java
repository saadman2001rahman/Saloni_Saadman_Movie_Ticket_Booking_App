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
	    String[] movieGenre = admin_movie_genre.getText().split(" ");
	    int movieLen = Integer.parseInt(admin_movie_len.getText());
	    double moviePrice = Double.parseDouble(admin_movie_base_price.getText());
	    String[] movieTheatre = admin_theatre.getText().split(" ");
	    String movie_rating = admin_movie_rating.getText();
	    
	    Movie thismovie = new Movie(movieName, movieGenre, movieLen, moviePrice, movieTheatre, movie_rating);
	    Admin admin = new Admin("admin", "admin", 0);
	    admin.addMovieToFile(thismovie);
	    	
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
