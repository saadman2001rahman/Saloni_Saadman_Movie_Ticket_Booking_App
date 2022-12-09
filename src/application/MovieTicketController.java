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
import javafx.event.EventHandler;
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
	
	private ConfirmController confirmcontroller;

    @FXML
    private TextField login_page_username_field;

    @FXML
    private Button login_page_login_button;

    @FXML
    private TextField login_page_password_field;
        
//    @FXML 
//    private ChoiceBox movies_choicebox;
    
    @FXML
    private Button rent_movies_button;
    
    @FXML
    private Label username_error_label;
    
    
    @FXML
    private Label passowrd_error_label;

//    private Label genreerrorlabel;
//
//    private Label nameerrorlabel;


    @FXML 
    Button new_acc_button;
    
    private Customer thiscustomer;
    
    private Movie thismovie;
    
        
    @FXML
    void check_login(ActionEvent event) throws IOException {
    	/**
    	 * Activates after login button is pressed in the first login scene. This will check whether username and password match with ones from record, and if they match, it will change the scene to one where there will be a list of movies to choose from.
    	 */
    	
    	String user_name = login_page_username_field.getText();
    	String password = login_page_password_field.getText();
    	
//    	boolean successful_login = true;
//    	boolean admin_login = false;
    	
    	//in case there is an error in the changing of scenes
    	Label temp_label = new Label("This is just temporary. Teting whether the scene changes to a new scene from login page.");
    	Scene movie_scene = new Scene(temp_label);
    	
    	if (user_name.equals("admin") && password.equals("admin")) {
    		//when an admin logs in, admin controller is loaded and scene changes to admin scene
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
    		//when a user logs in, scene changes to display all movies and seach controls
    		if (checkuser(user_name, password)) {		    	
    		ArrayList<HBox> allMovieNames = getAllMovies();
	    	int moviesadded = 0;
	    	int totalMovies = allMovieNames.size();
	    	
	    	Insets margin = new Insets(10, 10, 10, 10);

	    	
			VBox moviecontainer = new VBox();
//			moviecontainer.setPadding(margin);
			
			HBox searchByName = new HBox();
			Label namelabel = new Label("Search by name of Movie: ");
			namelabel.setPadding(margin);
			TextField searchMovieName = new TextField();
			searchMovieName.setPadding(margin);
			Button nameButton = new Button("Search");
			nameButton.setPadding(margin);
			Label nameerrorlabel = new Label("");
			nameButton.setOnAction(search -> {
				try {
					displayNameSearch(searchMovieName.getText(), nameerrorlabel);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			searchByName.getChildren().addAll(namelabel, searchMovieName, nameButton, nameerrorlabel);
			
			HBox searchByGenre = new HBox();
			Label genrelabel = new Label("Search by genre of Movie: ");
			genrelabel.setPadding(margin);
			TextField searchMovieGenre = new TextField();
			searchMovieGenre.setPadding(margin);
			Button genreButton = new Button("Search");
			genreButton.setPadding(margin);
			Label genreerrorlabel = new Label("");
			genreButton.setOnAction(searchagenre -> {
				try {
					displayGenreSearch(searchMovieGenre.getText(), genreerrorlabel);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			
			searchByGenre.getChildren().addAll(genrelabel, searchMovieGenre, genreButton, genreerrorlabel);
			Label text = new Label("Select a Movie you want to watch");
			text.setPadding(margin);
			moviecontainer.getChildren().add(text);
			moviecontainer.getChildren().add(searchByName);
			moviecontainer.getChildren().add(searchByGenre);
//			moviecontainer.getChildren().add(searchByTheatre);

			while (moviesadded < totalMovies) {
				
				moviecontainer.getChildren().add(allMovieNames.get(moviesadded));
				moviesadded++;

			}
			
			Scene allmoviescene = new Scene(moviecontainer, 800, 800);
			applicationStage.setScene(allmoviescene);
			
		
    		} 
    	}
    }
  
	public void displayGenreSearch(String text, Label errorlabel) throws IOException {
		/*
		 * activates when user searches for a genre of movie
		 * @param: text: genre user searched for
		 * @param: errorlabel: label which tells user when there is no search results
		 */
//    	Movie wanted = new Movie(text);
    	VBox searchContainer = new VBox();
    	
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
    	String line = reader.readLine();

    	Insets margin = new Insets(10, 10, 10, 10);
    	
    	int totalmovies = 0;
    	
    	while (line != null) {
    		String movieGenre = line.split("%%%")[6];
    		movieGenre = movieGenre.substring(0, movieGenre.length() - 1);
    		String[] words = movieGenre.split(" ");
//    		for (String word: words) {
//    			for (String aname: text.split(" ")) {
		    		if (movieGenre.contains(text)) {
		    			totalmovies++;
		    			
		        		Movie amovie = new Movie(line.split("%%%")[0], line.split("%%%")[6].split(" "), Integer.parseInt(line.split("%%%")[4]), Double.parseDouble(line.split("%%%")[5]), new Theater(Integer.parseInt(line.split("%%%")[2]), line.split("%%%")[3]));
		        		
		        		HBox moviecontainer = new HBox();
		        		Label moviename = new Label(line.split("%%%")[0]);
		        		Label moviegenre = new Label("Genres: " + line.split("%%%")[6]);
		        		Label movieprice = new Label("base price: $" + line.split("%%%")[5]);
	//	        		Label movietheatre = new Label(line.split("%%%")[2]);
		        		Label movieduration = new Label("Movie duration: " + line.split("%%%")[4]);
	//	        		Label movierating = new Label(line.split("%%%")[3]);
		        		
		        		moviename.setPadding(margin);
		        		moviegenre.setPadding(margin);
		        		movieprice.setPadding(margin);
	//	        		movietheatre.setPadding(margin);
		        		movieduration.setPadding(margin);
	//	        		movierating.setPadding(margin);
		
		        		Button watchButton = new Button("Watch this");
		        		
		        		watchButton.setOnAction(watch -> changetoconfirmscene(amovie, thiscustomer));
		        		watchButton.setPadding(margin);
		
		        		moviecontainer.getChildren().addAll(moviename, movieduration, movieprice, moviegenre, watchButton);
		        		
		        		searchContainer.getChildren().addAll(moviecontainer);
		        		
		    		}
//		    		break;
//    			}
    			
//    		}
    		line = reader.readLine();
    	}
    	
    	reader.close();
    	
    	if (totalmovies == 0) {
    		errorlabel.setText("No such movies found.");
    	} else {
    		Scene allmoviescene = new Scene(searchContainer, 800, 800);
    		applicationStage.setScene(allmoviescene);
    	}
	}

	public void displayNameSearch(String text, Label errorlabel) throws IOException {
		/*
		 * activates when user searches for a movie name
		 * @param: text: name user searched for
		 * @param: errorlabel: label which tells user when there is no search results
		 */
		
    	VBox searchContainer = new VBox();
    	
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
    	String line = reader.readLine();

    	Insets margin = new Insets(10, 10, 10, 10);
    	int totalmovies = 0;

    	while (line != null) {
    		String movieName = line.split("%%%")[0];
    		String[] words = movieName.split(" ");
//    		for (String word: words) {
    		if (movieName.contains(text)) {
        		totalmovies++;
        		Movie amovie = new Movie(line.split("%%%")[0], line.split("%%%")[6].split(" "), Integer.parseInt(line.split("%%%")[4]), Double.parseDouble(line.split("%%%")[5]), new Theater(Integer.parseInt(line.split("%%%")[2]), line.split("%%%")[3]));
        		
        		HBox moviecontainer = new HBox();
        		Label moviename = new Label(line.split("%%%")[0]);
        		Label moviegenre = new Label("Genres: " + line.split("%%%")[6]);
        		Label movieprice = new Label("base price: $" + line.split("%%%")[5]);
//	        		Label movietheatre = new Label(line.split("%%%")[2]);
        		Label movieduration = new Label("Movie duration: " + line.split("%%%")[4]);
//	        		Label movierating = new Label(line.split("%%%")[3]);
        		
        		moviename.setPadding(margin);
        		moviegenre.setPadding(margin);
        		movieprice.setPadding(margin);
//	        		movietheatre.setPadding(margin);
        		movieduration.setPadding(margin);
//	        		movierating.setPadding(margin);

        		Button watchButton = new Button("Watch this");
        		
        		watchButton.setOnAction(watch -> changetoconfirmscene(amovie, thiscustomer));
        		watchButton.setPadding(margin);

        		moviecontainer.getChildren().addAll(moviename, movieduration, movieprice, moviegenre, watchButton);
        		
        		searchContainer.getChildren().addAll(moviecontainer);
        		
    		}
//    		}
            line = reader.readLine();

    	}

    	

    	
    	reader.close();
    	
		if (totalmovies == 0) {
			errorlabel.setText("No such movies found.");
    	} else {
    		Scene allmoviescene = new Scene(searchContainer, 800, 800);
    		applicationStage.setScene(allmoviescene);
    	}
    	

	}

	@FXML
    void make_customer_account(ActionEvent thisisanewcustomer) {
		//activates when user wants to make a new account from login button. loads new account scene
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
    	/*
    	 * Checks if user is in the list of all users and verifies if password is correct. In the case when user is not found, an error label tells user to enter a different name. When password does not match with username, errorlabel tells user to enter a different password
    	 * @param: name: unique username of user
    	 * @param: pass: password entered by user
    	 */

    	boolean userfound = false;
    	boolean passed = true;
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/List_of_customers.txt"));
    	String line = reader.readLine();
    	while (line != null) {
    		String username = line.split("%%%")[0];
    		String password = line.split("%%%")[1];
    		
    		if (username.equals(name)) {
    			userfound = true;
    			if (!password.equals(pass)) {
    				passed = false;
    				passowrd_error_label.setText("Password does not match with account!");
    			} else {
        			thiscustomer = new Customer(username, line.split("%%%")[2], Integer.parseInt(line.split("%%%")[3]), 0);
        			reader.close();
        			return true;
    			}
    		}   
    		line = reader.readLine();
    	}
    	reader.close();
    	if (!userfound) {
        	username_error_label.setText("Username does not exist. Please try a different username or make an account!");
        	return false;
    	}   
    	
    	return passed;
    }
    
    ArrayList<HBox> getAllMovies() throws IOException {
    	/*
    	 * displays all movies that are stored in the system
    	 * @return: a list of HBox that contains the movie and the movies information that will be presented to the user
    	 */
    	BufferedReader reader = new BufferedReader(new FileReader("src/application/ListOfMovies.txt"));
    	String line = reader.readLine();
//    	String send = String.valueOf(line);
    	ArrayList<HBox> movielist = new ArrayList<HBox>();
    	
    	Insets margin = new Insets(10, 10, 10, 10);
    	
    	while (line != null) {
    		
    		HBox moviecontainer = new HBox();
    		Label moviename = new Label(line.split("%%%")[0]);
    		Label moviegenre = new Label("Genres: " + line.split("%%%")[6]);
    		Label movieprice = new Label("base price: $" + line.split("%%%")[5]);
//    		Label movietheatre = new Label(line.split("%%%")[2]);
    		Label movieduration = new Label("Movie duration: " + line.split("%%%")[4]);
//    		Label movierating = new Label(line.split("%%%")[3]);
    		
    		moviename.setPadding(margin);
    		moviegenre.setPadding(margin);
    		movieprice.setPadding(margin);
//    		movietheatre.setPadding(margin);
    		movieduration.setPadding(margin);
    		
    		Movie amovie = new Movie(line.split("%%%")[0], line.split("%%%")[6].split(" "), Integer.parseInt(line.split("%%%")[4]), Double.parseDouble(line.split("%%%")[5]), new Theater(Integer.parseInt(line.split("%%%")[2]), line.split("%%%")[3]));

    		
    		Button watchButton = new Button("Watch this");
    		
    		watchButton.setOnAction(watch -> changetoconfirmscene(amovie, thiscustomer));
    		watchButton.setPadding(margin);

    		

    		
    		moviecontainer.getChildren().addAll(moviename, movieduration, movieprice, moviegenre, watchButton);

    		
//    		String movieName = line.split("%%%")[0];
    		movielist.add(moviecontainer);
    		
    		line = reader.readLine();
    	}
    	reader.close();
    	return movielist;
    }
    
    private void changetoconfirmscene(Movie amovie, Customer acustomer) {
    	//activates when user wants to watch a movie. Displays all information about the movie as well as allows user to select seat and time of movie
		try {
			
    		FXMLLoader loader = new FXMLLoader();
    		VBox confirm = loader.load(new FileInputStream("src/application/movie_confirmation_scene.fxml"));
    		
    		thismovie = amovie;

    		confirmcontroller = loader.getController();
    		confirmcontroller.setPrimaryStage(applicationStage);
    		confirmcontroller.setMyScene(new Scene(confirm));
    		confirmcontroller.setCustomer(acustomer);
    		confirmcontroller.setMovie(thismovie);
    		confirmcontroller.m_confirm_price();
    		confirmcontroller.m_confirm_theatre();
    		confirmcontroller.m_confirm_name();
    		confirmcontroller.m_confirm_genre();
    		
    		confirmcontroller.changethescene();
    		
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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


