package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    void check_login(ActionEvent event) {
    	String user_name = login_page_username_field.getText();
    	String password = login_page_password_field.getText();
    	boolean successful_login = true;
    	
//    	Scene rent_movie_scene = new Scene();
//    	VBox temp_text_container = new VBox();
    	Label temp_label = new Label("This is just temporary. Teting whether the scene changes to a new scene from login page.");
//    	temp_text_container.getChildren().addAll(temp_label);
    	Scene rent_movie_scene = new Scene(temp_label);
    	
    	if (successful_login) {
    		applicationStage.setScene(rent_movie_scene);
    	}
    }
    
//    @FXML 
//    void rent_movies(ActionEvent rentMovies) {
//    	
//    }
}



