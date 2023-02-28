package app.controllers;

import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;

public class PantallaMenuController extends AppController {

 
        @FXML
        public MenuBar borderPane;

        @FXML
        private BorderPane borderPanel;

        @FXML
        private MenuItem btnMenuCB;

        @FXML
        private MenuItem btnMenuCerrar;

        @FXML
        private MenuItem btnMenuDP;

        @FXML
        private MenuItem btnMenuL;

     
        
        @FXML
        public void initialize() {
        	setPanelMenu(borderPanel);
        	borderPanel.setCenter(cargarVista(FxmlPaths.FXML_LOGIN));
        }

        @FXML
        void irAAñadir(ActionEvent event) {
        	borderPanel.setCenter(cargarVista(FxmlPaths.FXML_ANHADIR));
        }

        @FXML
        void irAListado(ActionEvent event) {
        	borderPanel.setCenter(cargarVista(FxmlPaths.FXML_LISTADO));
        }
       
        void irAPantallaPrincipal() {
        	borderPanel.setCenter(cargarVista(FxmlPaths.FXML_MAINSCREEN));
        }
        
        @FXML
        void cerrar(ActionEvent event) {
        	Alert a = new Alert(AlertType.CONFIRMATION);
        	a.setHeaderText(null);
        	a.setContentText("¿Estás seguro de que quieres cerrar la aplicación?");
        	a.setTitle("Cerrar");
        	Optional<ButtonType> result = a.showAndWait();
        	if(result.get()== ButtonType.OK) {	
        		Platform.exit();
        	}
        	else if(result.get()== ButtonType.CANCEL) {
        		
        	}
        	
        }

        @FXML
        void hacerLogout(ActionEvent event) {
        	borderPanel.setCenter(cargarVista(FxmlPaths.FXML_LOGIN));
        }

		public MenuBar getBorderPane() {
			return borderPane;
		}

		public void setBorderPane(MenuBar borderPane) {
			this.borderPane = borderPane;
		}

		public BorderPane getBorderPanel() {
			return borderPanel;
		}

		public void setBorderPanel(BorderPane borderPanel) {
			this.borderPanel = borderPanel;
		}

    
        



}

