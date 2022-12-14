package application;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			VBox root = loader.load(new FileInputStream("src/application/login_page.fxml"));
			MovieTicketController controller = (MovieTicketController) loader.getController();
			controller.setPrimaryStage(primaryStage);
			

			Scene scene = new Scene(root,500,500);
			
			controller.setMyScene(scene);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Movie Ticket Booking System");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}  
}
