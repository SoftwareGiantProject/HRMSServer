package rmihelper;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Start extends Application {

	private static StartController controller = null;
	
	public static void sendMessage(String names){
		if(controller != null){
			controller.sendMessage(names);
		}
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle("Server");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Start.class.getResource("RMIScene.fxml"));
		AnchorPane pane = null;
		try{
			pane = (AnchorPane) loader.load();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		controller = loader.getController();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
