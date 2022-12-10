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
import javafx.scene.control.Label;
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
    
    @FXML
    private Label name_error_label;
    
    @FXML
    private Label ageerrorlabel;
    
    private Stage applicationStage;
    
    private Scene myScene;
    
    private MovieTicketController nextController;


    @FXML
    void create_account(ActionEvent event) throws IOException {
    	//activates when user wishes to create an account with the information they put in. Also checks whether username already exists in file, in which case an errorlabel tells the user to enter another username.
//    	BufferedReader reader = new BufferedReader(new FileReader("src/application/List_of_customers.txt"));
//    	String line = reader.readLine();
	    String specialChar = "%%%";
	    
	    String inp = new_userID.getText();
	    Validate_Inputs aninp = new Validate_Inputs();
	    boolean exists = aninp.check_if_user_exists(inp);
	    
	    boolean errorinage = false;
	    String age = new_customer_age.getText();
	    Validate_Inputs ageinp = new Validate_Inputs(0, 100);
	    String ageerror = ageinp.setValueInt(age);
	    ageerrorlabel.setText(ageerror);
	    if (!ageerror.equals("")) {
	    	errorinage = true;
	    }
    	
    	if (exists || errorinage) {
			name_error_label.setText("userID has to be unique");
    	} else {
        	BufferedWriter writer = new BufferedWriter(new FileWriter("src/application/List_of_customers.txt", true));
        	String userLine = new_userID.getText() + specialChar + new_customer_pass.getText() + specialChar + new_customer_name.getText() + specialChar + ageinp.getIntVal();
        	
        	writer.write(userLine + "\n");
        	
        	writer.close();
        	
        	nextController.changethescene();
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
