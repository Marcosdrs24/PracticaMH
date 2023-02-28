package app.controllers;

import java.util.Optional;

import app.modelo.Wyvern;
import app.services.WyvernsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class EscribirNotaController extends AppController {

	@FXML
	private Button btnConfirmar;

	@FXML
	private Button btnVolver;

	@FXML
	private TextArea txtNota;

	public Wyvern wyvGuardado;

	@FXML
	void confirmar(ActionEvent event) {
		WyvernsService service = new WyvernsService();
		if (txtNota.getText().isEmpty()) {
			service.actualizarNotas(wyvGuardado.getId(), null);
		} else {
			service.actualizarNotas(wyvGuardado.getId(), txtNota.getText());
		}
		cambiarVistaMenu(FxmlPaths.FXML_LISTADO);
		Alert a = new Alert(AlertType.INFORMATION);
		a.setHeaderText(null);
		a.setContentText("Sus notas han cambiado con éxito");
		a.setTitle("Completado");
		a.showAndWait();
	}

	@FXML
	void volver(ActionEvent event) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Estás seguro de que quieres cancelar el proceso?");
		a.setTitle("Cerrar");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			InfoAmpliadaController mInfoController = (InfoAmpliadaController) cambiarVistaMenu(FxmlPaths.FXML_AMPLIAR);
			mInfoController.rellenarTodo(wyvGuardado);
		} else if (result.get() == ButtonType.CANCEL) {

		}
	}

	public void guardarWyv(Wyvern wyvRecibido) {
		wyvGuardado = wyvRecibido;
	}

}
