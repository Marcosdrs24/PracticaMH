package app.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import app.App;
import app.modelo.Wyvern;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InfoAmpliadaController extends AppController {

	@FXML
	private Button btnCazado;

	@FXML
	private Button btnEscribirNotas;

	@FXML
	private Button btnNotas;

	@FXML
	private Button btnVolver;

	@FXML
	private Text txtCazado;
	
	
	@FXML
	private Text txtListaMateriales;

	@FXML
	private Text txtNotas;
	
	@FXML
	private Text txtTamaño;

	@FXML
	private Text txtTipo;
	
	@FXML
	private ImageView imgHostilidad;

	

	private Wyvern wyvSeleccionado;

	private void initialize() {

	}

	public void rellenarTodo(Wyvern seleccionado) {
		wyvSeleccionado = seleccionado;
		txtTamaño.setText(seleccionado.getTamaño().toString());
		txtTipo.setText(seleccionado.getTipo());
		txtNotas.setText(seleccionado.getNotas());
		if(seleccionado.getNotas()== null) {
			txtNotas.setText("\"No hay notas para este wyvern\"");
		}
		List<String> materiales = seleccionado.getMateriales();
		String delim = "\n" + "-";
		Image imagen = new Image("/imagenes/" + seleccionado.getHostilidad() + " star.png");
	
		imgHostilidad.setImage(imagen);
		StringBuilder sb = new StringBuilder();

		int i = 0;
		while (i < materiales.size() - 1) {
			sb.append(materiales.get(i));
			sb.append(delim);
			i++;
		}
		sb.append(materiales.get(i));

		String res = sb.toString();
		txtListaMateriales.setText("-" + res);

		if (seleccionado.getCazado() == true) {
			txtCazado.setText("Wyvern cazado con éxito");
		} else if (seleccionado.getCazado() == false) {
			txtCazado.setText("No has cazado ningún ejemplar de " + seleccionado.getNombre() + " por ahora");
		}
	}

	@FXML
	void escribirNotas(ActionEvent event) {
		EscribirNotaController eNController = (EscribirNotaController)cambiarVistaMenu(FxmlPaths.FXML_ESCRIBIR);
		eNController.guardarWyv(wyvSeleccionado);
	}
	
	void nuevasNotas(String notas) {
		txtNotas.setText(notas);
	}
	@FXML
	void volver(ActionEvent event) {
		MasInfoController mInfoController = (MasInfoController) cambiarVistaMenu(FxmlPaths.FXML_MASINFO);
		mInfoController.rellenarTodo(wyvSeleccionado);
		
	}

	@FXML
	void cambiarEstado(ActionEvent event) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Estás seguro de que quieres cambiar el estado de caza de este wyvern?");
		a.setTitle("Cambiar estado de caza");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			if (wyvSeleccionado.getCazado() == true) {
				wyvSeleccionado.setCazado(false);
				txtCazado.setText("No has cazado ningún ejemplar de " + wyvSeleccionado.getNombre() + " por ahora");
			} else if (wyvSeleccionado.getCazado() == false) {
				wyvSeleccionado.setCazado(true);
				txtCazado.setText("Wyvern cazado con éxito");
			}

		} else if (result.get() == ButtonType.CANCEL) {

		}

	}
	
	
	void cambiarNotas(String notasNuevas) {
		txtNotas.setText(notasNuevas);
	}
	

}