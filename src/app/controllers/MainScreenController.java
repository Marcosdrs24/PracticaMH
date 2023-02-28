package app.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class MainScreenController extends AppController {

	@FXML
	private Button btnAnhadir;

	@FXML
	private Button btnCambiar;

	@FXML
	private Button btnMisNotas;

	@FXML
	private Button btnVolver;
    @FXML
    private ImageView imgOpciones;

	@FXML
	void irAAnhadir(ActionEvent event) {
		cambiarVistaMenu(FxmlPaths.FXML_ANHADIR);
	}

	@FXML
	void irAMisNotas(ActionEvent event) {
		cambiarVistaMenu(FxmlPaths.FXML_LISTADO);
		
	}

	@FXML
	void volverALogin(ActionEvent event) {
		cambiarVista(FxmlPaths.FXML_LOGIN);
		
	}

}

