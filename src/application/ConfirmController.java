package application;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    
    @FXML
    private ChoiceBox<String> seat_row;
    
    @FXML
    private ChoiceBox<String> seat_column;

    @FXML
    private ChoiceBox<String> movie_time;

    
    private FinalSceneController nextController;
    
    private MovieTicketController prevController;
    
    private Stage applicationStage;
    
    private Scene myScene;
    
    private Movie thismovie;
    
    private Customer thiscustomer;
    

    @FXML
    void movie_confirmed(ActionEvent event) {
    	try {
    		FXMLLoader finalloader = new FXMLLoader();
    		VBox finalScene = finalloader.load(new FileInputStream("src/application/final_scene.fxml"));
    		
    		nextController = finalloader.getController();
    		nextController.setPrimaryStage(applicationStage);
    		nextController.setMyScene(new Scene(finalScene));
    		
    		
        	nextController.setNameOfCustomer(thiscustomer.getName());
        	nextController.setNameOfTheatre(thismovie.getMovieName());
        	nextController.setDateAndTime();
        	nextController.setNameOfMovie(thismovie.getMovieName());
        	nextController.setPrice(Double.toString(thismovie.getbasePrice()));
//        	Validate_Inputs column = new Validate_Inputs();
//        	String anerror = column.setValueInt(seat_column.getValue());
        	
        	nextController.setSeat(new Seat(seat_row.getValue().charAt(0), Integer.parseInt(seat_column.getValue())));
        	
        	nextController.setTime(movie_time.getValue());
        	        	
        	nextController.changethescene();


    	} catch (Exception e) {
    		e.printStackTrace();
        	System.out.println("This didnt work");

    	}
    	
    }

    @FXML
    void movie_cancelled(ActionEvent event) {
    	try {
    		FXMLLoader back = new FXMLLoader();
    		VBox change = back.load(new FileInputStream("src/application/login_page.fxml"));
    		
    		prevController = back.getController();
    		prevController.setPrimaryStage(applicationStage);
    		prevController.setMyScene(new Scene(change));
        	prevController.changethescene();

    	} catch (Exception e) {
    		e.printStackTrace();
        	System.out.println("This didnt work");

    	}

    }
    
    void setMyScene(Scene ascene) {
    	myScene = ascene;
    }

	public void setPrimaryStage(Stage astage) {
		applicationStage = astage;		
	}

	public void setNextController(FinalSceneController acontroller) {
		nextController = acontroller;
	}
	
	void changethescene() {
		applicationStage.setScene(myScene);
	}
	
	void setMovie(Movie amovie) {
		thismovie = amovie;
	}
	
	void setCustomer(Customer acustomer) {
		thiscustomer = acustomer;
	}
	
	void m_confirm_genre() {
		confirm_genre.setText(thismovie.getGenres());
	}
	
	void m_confirm_name() {
		confirm_name.setText(thismovie.getMovieName());
	}

	void m_confirm_theatre() {
		confirm_theatre.setText(thismovie.getMovieName());
	}

	void m_confirm_price() {
		confirm_price.setText(Double.toString(thismovie.getbasePrice()));
	}

	
	


}
