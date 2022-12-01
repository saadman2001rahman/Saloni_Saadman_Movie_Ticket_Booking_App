package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieTicketController {
	private Stage applicationStage;
	
	private Scene myScene;
	
	private AdminController theadmincontrols;
	
	private New_Customer_Controller newcustomercontrols;

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
    
    @FXML Button new_acc_button;
    
        
    @FXML
    void check_login(ActionEvent event) throws IOException {
    	/**
    	 * Activates after login button is pressed in the first login scene. This will check whether username and password match with ones from record, and if they match, it will change the scene to one where there will be a list of movies to choose from.
    	 */
    	
    	String user_name = login_page_username_field.getText();
    	String password = login_page_password_field.getText();
    	
    	boolean successful_login = true;
    	boolean admin_login = false;
    	
    	//in case there is an error in the changing of scenes
    	Label temp_label = new Label("This is just temporary. Teting whether the scene changes to a new scene from login page.");
    	Scene movie_scene = new Scene(temp_label);
    	
    	if (user_name.equals("admin") && password.equals("admin")) {
    		try {
        		FXMLLoader adminLoader = new FXMLLoader();
        		VBox adminscene = adminLoader.load(new FileInputStream("src/application/admin_page.fxml"));
        		
        		theadmincontrols = adminLoader.getController();
        		theadmincontrols.setPrimaryStage(applicationStage);
        		theadmincontrols.setMyScene(new Scene(adminscene));
        		theadmincontrols.setNextController(this);
        		
        		
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		theadmincontrols.changethescene();

    	} 
    	else {
    		if (checkuser(user_name, password)) {
//		    	try {
//		    		FXMLLoader file_loader = new FXMLLoader();
//		        	VBox search_movie_container = file_loader.load(new FileInputStream("src/application/movie_confirmation_scene.fxml"));
//		        	
//		        	movie_scene = new Scene(search_movie_container);
//		    		
//		    		
//		
//				} catch(Exception e) {
//					e.printStackTrace();
//				}		    	
//		    	applicationStage.setScene(movie_scene);
		    	ArrayList<HBox> allMovieNames = getAllMovies();
		    	int moviesadded = 0;
		    	int totalMovies = allMovieNames.size();
		    	
    			VBox moviecontainer = new VBox();
    			while (moviesadded < totalMovies) {
//    				HBox movieContainer = new HBox();
//    				Label movieLabel = new Label(allMovieNames.get(moviesadded));
    				
//    				movieContainer.getChildren().add(movieLabel);
    				
    				
    				moviecontainer.getChildren().add(allMovieNames.get(moviesadded));
    				moviesadded++;

    			}
    			
    			Scene allmoviescene = new Scene(moviecontainer, 800, 800);
    			applicationStage.setScene(allmoviescene);
    			
    		} else {
    			System.out.println("Creds not right");
    		}
    	}
    }

    	
    		
    	
    
    @FXML
    void make_customer_account(ActionEvent thisisanewcustomer) {
		try {
    		FXMLLoader newcustomerloader = new FXMLLoader();
    		VBox newcustomerscene = newcustomerloader.load(new FileInputStream("src/application/new_customer_scene.fxml"));
    		
    		newcustomercontrols = newcustomerloader.getController();
    		newcustomercontrols.setPrimaryStage(applicationStage);
    		newcustomercontrols.setMyScene(new Scene(newcustomerscene));
    		newcustomercontrols.setNextController(this);
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		newcustomercontrols.changethescene();
    }
    
    boolean checkuser(String name, String pass) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/List_of_customers.txt"));
    	String line = reader.readLine();
    	while (line != null) {
    		String username = line.split("%%%")[0];
    		String password = line.split("%%%")[1];
    		
    		if (username.equals(name) && password.equals(pass)) {
    			reader.close();
    			return true;
    		}   
    		line = reader.readLine();
    	}
    	reader.close();
    	return false;
    }
    
    ArrayList<HBox> getAllMovies() throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
    	String line = reader.readLine();
    	ArrayList<HBox> movielist = new ArrayList<HBox>();
    	
    	Insets margin = new Insets(10, 10, 10, 10);
    	
    	while (line != null) {
    		
    		HBox moviecontainer = new HBox();
    		Label moviename = new Label(line.split("%%%")[0]);
    		Label moviegenre = new Label(line.split("%%%")[5]);
    		Label movieprice = new Label(line.split("%%%")[4]);
    		Label movietheatre = new Label(line.split("%%%")[1]);
    		Label movieduration = new Label(line.split("%%%")[3]);
    		Label movierating = new Label(line.split("%%%")[2]);
    		
    		moviename.setPadding(margin);
    		moviegenre.setPadding(margin);
    		movieprice.setPadding(margin);
    		movietheatre.setPadding(margin);
    		movieduration.setPadding(margin);
    		movierating.setPadding(margin);
    		
    		Button watchButton = new Button("Watch this");
//    		watchButton.setOnAction(watch -> )
    		

    		
    		moviecontainer.getChildren().addAll(moviename, movietheatre, movierating, movieduration, movieprice, moviegenre);

    		
//    		String movieName = line.split("%%%")[0];
    		movielist.add(moviecontainer);
    		
    		line = reader.readLine();
    	}
    	reader.close();
    	return movielist;
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


