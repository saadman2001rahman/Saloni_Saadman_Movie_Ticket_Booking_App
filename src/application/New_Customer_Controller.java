package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class New_Customer_Controller {

    @FXML
    private TextField new_customer_name;

    @FXML
    private TextField new_customer_age;

    @FXML
    private Button create_account_button;

    @FXML
    private TextField new_customer_pass;
    
    @FXML 
    private TextField new_userID;
    
    private Stage applicationStage;
    
    private Scene myScene;
    
    private MovieTicketController nextController;


    @FXML
    void create_account(ActionEvent event) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/List_of_customers.txt"));
    	String line = reader.readLine();
	    String specialChar = "%%%";

    	while (line != null) {
    		String userID = line.split(specialChar)[0];
    		if (userID.equals(new_userID)) {
    			System.out.println("userID has to be unique");
    			break;
    		}
    		line = reader.readLine();
    	}
    	
    	reader.close();
    	
    	BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/List_of_customers.txt", true));
    	String userLine = new_userID.getText() + specialChar + new_customer_pass.getText() + specialChar + new_customer_name.getText() + specialChar + new_customer_age.getText();
    	
    	writer.write(userLine + "\n");
    	
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
