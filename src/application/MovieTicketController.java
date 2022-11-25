package application;

import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieTicketController {
	Stage applicationStage;

    @FXML
    private TextField login_page_username_field;

    @FXML
    private Button login_page_login_button;

    @FXML
    private TextField login_page_password_field;
        
    @FXML 
    private ChoiceBox movies_choicebox;
    
    @FXML
    private Button rent_movies_button;
    
    @FXML 
    ImageView imageView;
    
    @FXML
    void check_login(ActionEvent event) {
    	/**
    	 * Activates after login button is pressed in the first login scene. This will check whether username and password match with ones from record, and if they match, it will change the scene to one where there will be a list of movies to choose from.
    	 */
    	
    	Scene home_scene = applicationStage .getScene();
    	String user_name = login_page_username_field.getText();
    	String password = login_page_password_field.getText();
    	boolean successful_login = true;
    	Label temp_label = new Label("This is just temporary. Teting whether the scene changes to a new scene from login page.");
    	Scene rent_movie_scene = new Scene(temp_label);

    	try {
    		FXMLLoader file_loader = new FXMLLoader();
        	VBox rent_movie_container = file_loader.load(new FileInputStream("src/application/rent_movie_scene.fxml"));
        	
        	MovieTicketController acontroller = file_loader.getController();
			acontroller.applicationStage = applicationStage;

        	
        	rent_movie_scene = new Scene(rent_movie_container);

		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	if (successful_login) {
    		applicationStage.setScene(rent_movie_scene);
    	}
    }
    
    @FXML
    void movie_selected(ActionEvent user_selected_movie) {
    	/**
    	 * Activates after user chooses a movie to view, in which case it displays all information on the movie. Info includes movie title, genres, producer/author/director/actors, length, price of the movie, seating arrangement (***maybe another scene for seating arrangement??***)
    	 */
    	Label a_label = new Label("This is just temporary. Teting whether the scene changes to a new scene from login page.");
    	Scene movie_info_scene = new Scene(a_label);

    	try {
    		FXMLLoader file_loader = new FXMLLoader();
        	VBox movie_info_container = file_loader.load(new FileInputStream("src/application/movie_info_scene.fxml"));
        	
        	
        	movie_info_scene = new Scene(movie_info_container);

		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    	applicationStage.setScene(movie_info_scene);
    }
    
//    void go_to_home_page(ActionEvent going_to_home_page) {
//    	applicationStage.setScene()
//    }
}


