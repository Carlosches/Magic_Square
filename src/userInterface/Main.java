package userInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;



public class Main extends Application{
	/**
	 * this method starts the program
	 * @param args, unused
	 */
	public static void main(String[] args) {
		launch(args);

	}
	/**
	 * The main entry point of the project
	 * @param stage, Main window
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("mSquare.FXML"));
	
		
		Scene scene = new Scene(root);
		stage.setTitle("MAGIC SQUARE");
		stage.setScene(scene);
		stage.show();
		
		
		
	}

}
