package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML
    private Label movie_name_error_label;
    
    @FXML
    private Label price_error_label;

    @FXML
    private Label movie_len_error_label;
    
    @FXML
    private Label number_error_label;
    
    @FXML
    private TextField admin_feature;

    private Stage applicationStage;
    
    private Scene myScene;
    
    private MovieTicketController nextController;

    @FXML
    void add_the_movie(ActionEvent event) throws IOException {
 		/*
 		 * Activated when admin presses button to add movie 
 		 */

    	boolean movieAdded = false;
    	
    	//checks if movie already exists in file
	    String movieName = admin_movie_name.getText();
	    Validate_Inputs nameofmovie = new Validate_Inputs();
	    movieAdded = nameofmovie.check_if_movie_exists(movieName);
	    
	    if (!movieAdded) {
		    String[] movieGenre = admin_movie_genre.getText().split(" ");
		    
		    //checks if the length of the movie is of type int
		    Validate_Inputs lengthofmovie = new Validate_Inputs(0, 1000);
		    String len_error_message = lengthofmovie.setValueInt(admin_movie_len.getText());
		    movie_len_error_label.setText(len_error_message);
		    
		    //checks if the price of movie is of type double
		    Validate_Inputs priceofmovie = new Validate_Inputs(0.0, 1000.0);
		    String price_error_message = priceofmovie.setValueDouble(admin_movie_base_price.getText());
		    price_error_label.setText(price_error_message);
		    
		    //checks if the theater number is of type int
		    Validate_Inputs theaternumber = new Validate_Inputs(1, 10);
		    String theatererrormessage = theaternumber.setValueInt(admin_theatre.getText());
		    number_error_label.setText(theatererrormessage);


		    if (price_error_message.equals("") && len_error_message.equals("") && theatererrormessage.equals("")) {
	    	
			    //if all input is valid, instance of admon, movie and theater is creeated, and movie is added to file
			    Theater atheater = new Theater(theaternumber.getIntVal(), admin_feature.getText());
			    Movie thismovie = new Movie(movieName, movieGenre, lengthofmovie.getIntVal(), priceofmovie.getDoubleVal(), atheater);
			    Admin admin = new Admin("admin", "admin", 0);
			    admin.addMovieToFile(thismovie);

			    nextController.changethescene();
		    }
	    } else {
	    	movie_name_error_label.setText("Movie already exists. Please add a different movie!");
	    }
	    
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
