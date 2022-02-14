package org.nitc.NewStock;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
	private static String tenNganh;
	private static String tenCP; 
	
	
	
    public static String getTenCP() {
		return tenCP;
	}

	public static void setTenCP(String tenCP) {
		App.tenCP = tenCP;
	}

	public static String getTenNganh() {
		return tenNganh;
	}

	public static void setTenNganh(String a) {
		App.tenNganh = a;
	}

	private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("LoginPage"), 921, 621);
        stage.setScene(scene);
        Show("aa", "aa");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void Show (String title, String header) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Test Connection");
		alert.setHeaderText("Results:");
		alert.setContentText("Connect to the database successfully!");
		
		alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch();
    }
    

}