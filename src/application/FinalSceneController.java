package application;

import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FinalSceneController {

    @FXML
    private Label final_name_of_movie;

    @FXML
    private Label final_date_and_time;

    @FXML
    private Label final_price;

    @FXML
    private Label final_name_of_customer;

    @FXML
    private Label final_theatre_name;
    
    private Scene myScene;
    
    private Stage applicationStage;
    
    void setNameOfCustomer(String name) {
    	final_name_of_customer.setText(name);
    }
    
    void setNameOfMovie(String name) {
    	final_name_of_movie.setText(name);
    }
    
    void setDateAndTime() {
    	Date thisDate = new Date();
    	final_date_and_time.setText(thisDate.toString());
    }
    
    void setNameOfTheatre(String name) {
    	final_theatre_name.setText(name);
    }
    
    void setPrice(String price) {
    	final_price.setText(price);
    }

    void setMyScene(Scene ascene) {
    	myScene = ascene;
    }
    
    void setPrimaryStage(Stage astage) {
    	applicationStage = astage;
    }
    
	void changethescene() {
		applicationStage.setScene(myScene);
	}
	
}
