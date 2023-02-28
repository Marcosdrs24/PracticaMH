package app.controllers;


import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class LoginController extends AppController{

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnSalir;

    @FXML
    private PasswordField txtFContrasenha;

    @FXML
    private TextField txtFUsuario;
    @FXML
    private AnchorPane pane;

    @FXML
    void entrar(ActionEvent event) {
    	
    	PantallaMenuController pm = (PantallaMenuController) cambiarVista(FxmlPaths.FXML_MENU);
    	pm.irAPantallaPrincipal();
    }

    @FXML
    void salir(ActionEvent event) {
    	Alert a = new Alert(AlertType.CONFIRMATION);
    	a.setHeaderText(null);
    	a.setContentText("¿Estás seguro de que quieres cerrar la aplicacion?");
    	a.setTitle("Cerrar");
    	Optional<ButtonType> result = a.showAndWait();
    	if(result.get()== ButtonType.OK) {	
    		Platform.exit();
    	}
    	else if(result.get()== ButtonType.CANCEL) {
    		
    	}
    	
    }
   

}

