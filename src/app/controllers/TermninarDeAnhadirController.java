package app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import app.modelo.Contador;
import app.modelo.Wyvern;
import app.services.WyvernsService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TermninarDeAnhadirController extends AppController {
	private static Wyvern wyvernRecibido;

	@FXML
	private Button btnCancelar;

	@FXML
	private Button btnConfirmar;

	@FXML
	private Spinner<Double> centimetros;

	@FXML
	private TextField materiales1;

	@FXML
	private TextField materiales2;

	@FXML
	private TextField materiales3;

	@FXML
	private TextField materiales4;

	@FXML
	private Spinner<Double> metros;

	@FXML
	private TextArea txtDescripcion;

	@FXML
	private TextArea txtNotas;

	SpinnerValueFactory<Double> valueFactoryM;

	static SpinnerValueFactory<Double> valueFactoryCM;

	@FXML
	public void initialize() {

		valueFactoryM = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.1, 100.0);
		valueFactoryM.setValue(0.1);
		metros.setValueFactory(valueFactoryM);
		valueFactoryCM = new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 99.9);
		valueFactoryCM.setValue(1.0);
		centimetros.setValueFactory(valueFactoryCM);
	}

	@FXML
	void cancelar(ActionEvent event) {
		Alert a = new Alert(AlertType.CONFIRMATION);
		a.setHeaderText(null);
		a.setContentText("¿Estás seguro de que quieres cancelar el proceso?");
		a.setTitle("Cancelar");
		Optional<ButtonType> result = a.showAndWait();
		if (result.get() == ButtonType.OK) {
			cambiarVistaMenu(FxmlPaths.FXML_MAINSCREEN);
		} else if (result.get() == ButtonType.CANCEL) {
			
		}
	}

	@FXML
	void confirmar(ActionEvent event) {
		if (txtDescripcion.getText().isEmpty() || txtNotas.getText().isEmpty()) {
			Alert a = new Alert(AlertType.CONFIRMATION);
			a.setHeaderText(null);
			a.setContentText("Algunos datos están sin completar. ¿Seguro que deseas continuar?");
			a.setTitle("Atención");
			Optional<ButtonType> result = a.showAndWait();
			if (result.get() == ButtonType.OK) {
				anhadirWyvern();
			} else if (result.get() == ButtonType.CANCEL) {

			}

			else {

			}
		} else {
			anhadirWyvern();
		}

	}

	public void anhadirWyvern() {
		Wyvern nuevoWyv = getWyvernRecibido();
		if (txtDescripcion.getText().isEmpty()) {
			nuevoWyv.setDescripición(null);
		} else {
			nuevoWyv.setDescripición(txtDescripcion.getText());
		}
		
		List<String> materiales = new ArrayList<>();
		materiales.add(materiales1.getText());
		materiales.add(materiales2.getText());
		materiales.add(materiales3.getText());
		materiales.add(materiales4.getText());
		nuevoWyv.setMateriales(materiales);		
		Double centimetrosSuma = (valueFactoryCM.getValue() * 0.01);
		Double total = (valueFactoryM.getValue() + centimetrosSuma);
		nuevoWyv.setTamaño(total);
		if (txtNotas.getText().isEmpty()) {
			nuevoWyv.setNotas(null);
		} else {
			nuevoWyv.setNotas(txtNotas.getText());
		}
		WyvernsService service = new WyvernsService();
		
		Integer numeroId = service.getContador();
		if(numeroId>5) {
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText(null);
			a.setContentText("Has alcanzado el límite de almacenamiento de wyverns");
			a.setTitle("ERROR");
			a.showAndWait();
			cambiarVistaMenu(FxmlPaths.FXML_MAINSCREEN);
		}
		else {
		String numeroIdStr = numeroId.toString();
		nuevoWyv.setId("WN" + numeroIdStr);
		
		service.insertarWyvern(nuevoWyv);
		cambiarVistaMenu(FxmlPaths.FXML_MAINSCREEN);
		}
	}

	public void recibirWyvern(Wyvern wyvern) {
		wyvernRecibido = wyvern;
	}

	private Wyvern getWyvernRecibido() {
		return wyvernRecibido;
	}
}
