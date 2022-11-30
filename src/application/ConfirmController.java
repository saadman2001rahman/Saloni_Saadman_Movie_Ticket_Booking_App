package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfirmController {

    @FXML
    private Button cancel_button;

    @FXML
    private Label confirm_genre;

    @FXML
    private Label confirm_name;

    @FXML
    private Button confirm_button;

    @FXML
    private Label confirm_theatre;

    @FXML
    private Label confirm_price;
    
    private FinalSceneController nextController;
    
    private MovieTicketController prevController;
    
    private Stage applicationStage;

    @FXML
    void movie_confirmed(ActionEvent event) {
    	try {
    		FXMLLoader finalloader = new FXMLLoader();
    		VBox finalScene = finalloader.load(new FileInputStream("src/application/final_scene.fxml"));
    		
    		nextController = finalloader.getController();
    		nextController.setPrimaryStage(applicationStage);
    		nextController.setMyScene(new Scene(finalScene));
    		
        	nextController.setNameOfCustomer("Saadman");
        	nextController.setNameOfTheatre("Cinemax");
        	nextController.setDateAndTime();
        	nextController.setNameOfMovie("Despicable me");
        	
        	System.out.println("This worked");
        	
        	nextController.changethescene();


    	} catch (Exception e) {
    		e.printStackTrace();
        	System.out.println("This didnt work");

    	}
    	
    }

    @FXML
    void movie_cancelled(ActionEvent event) {
    	prevController.changethescene();
    }

}
