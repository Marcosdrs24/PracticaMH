package app.controllers;

import java.io.IOException;
import java.net.URL;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class AppController {
	private static Stage primaryStage;
	private static BorderPane panelMenu;
	
	public AppController() {}
	public AppController(Stage stage) {
		primaryStage = stage;
	}
	
	public static BorderPane getPanelMenu() {
		return panelMenu;
	}
	public static void setPanelMenu(BorderPane panelMenu) {
		AppController.panelMenu = panelMenu;
	}
	@FXML
	public AppController cambiarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader = new FXMLLoader(url);
			Scene scene = new Scene(loader.load());
			
			primaryStage.setScene(scene);
			
		   
			return loader.getController();
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la ruta " + fxml, e);
		}

	}
	@FXML
	public Parent cargarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader = new FXMLLoader(url);			
			return loader.load();
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la ruta " + fxml, e);
		}

	}
	
	@FXML
	public AppController cambiarVistaMenu(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader = new FXMLLoader(url);
			panelMenu.setCenter(loader.load());
			return loader.getController();
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar la ruta " + fxml, e);
		}

	}
	
	
}
