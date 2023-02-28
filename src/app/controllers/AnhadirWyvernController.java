package app.controllers;

import java.util.Optional;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.App;
import app.modelo.Wyvern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;

public class AnhadirWyvernController extends AppController {
	private final static Logger log = LogManager.getLogger(App.class);
	@FXML
	private Button btnCancelar;
	@FXML
	private ComboBox<String> cbTipos;

	@FXML
	private Button btnCancelar1;


    @FXML
    private CheckBox btncazado;

	@FXML
	private TextField tFieldNombre;

	@FXML
	private ImageView estrellasHostilidad;
	
	SpinnerValueFactory<Integer> valueFactory;
	
	@FXML
	private Spinner<Integer> valorHostilidad;

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
	public void initialize() {
		cbTipos.getItems().add("Wyvern volador");
		cbTipos.getItems().add("Wyvern Pájaro");
		cbTipos.getItems().add("Wyvern Carapaceon");
		cbTipos.getItems().add("Wyvern Bestia");
		cbTipos.getItems().add("Wyvern Anfibio");
		cbTipos.getItems().add("Wyvern Colmillo");
		cbTipos.getItems().add("Wyvern Leviatán");
		cbTipos.getItems().add("Wyvern Bruto");
		cbTipos.getItems().add("Wyvern Serpiente");
		cbTipos.getItems().add("Dragón Anciano");
		cbTipos.getItems().add("???");
		valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 7);
		valueFactory.setValue(1);
		valorHostilidad.setValueFactory(valueFactory);
	
	}

	@FXML
	void continuar(ActionEvent event) {
		if (tFieldNombre.getText().isEmpty() || cbTipos.getSelectionModel().getSelectedItem()==null) {
			log.log(Level.ERROR,("Campos necesarios no rellenados"));
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText(null);
			a.setContentText("Debe insertar todos los datos del wyvern que desea añadir a la lista");
			a.setTitle("ERROR");
			a.showAndWait();
		} else {
			Wyvern wyvEnviar= new Wyvern();
			String seleccionado = cbTipos.getSelectionModel().getSelectedItem();
			wyvEnviar.setTipo(seleccionado);
			wyvEnviar.setCazado(marcado());
			wyvEnviar.setNombre(tFieldNombre.getText());
			wyvEnviar.setHostilidad(valueFactory.getValue());
			
			TermninarDeAnhadirController TAController = new TermninarDeAnhadirController();
			TAController = (TermninarDeAnhadirController) cambiarVistaMenu(FxmlPaths.FXML_TERMINAR_ANHADIR);
			
			TAController.recibirWyvern(wyvEnviar);
		}

	}

	private Boolean marcado() {
		if(btncazado.isSelected()) {
		return true;
		}
		else {
		return false;
		}
	}
}