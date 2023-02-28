package app.controllers;

import java.util.List;

import app.modelo.Wyvern;
import app.services.WyvernsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListaWyvernsController extends AppController {

	@FXML
	private TableColumn<Wyvern, String> columnaNombre;

	@FXML
	private Button btnInfo;

	@FXML
	private Button btnVovler;

	@FXML
	private ImageView imagenWyv;

	@FXML
	private TableView<Wyvern> tablaWyverns;

	private ObservableList<Wyvern> datos;

	public void initialize() {

		PropertyValueFactory<Wyvern, String> factoryValueNombre = new PropertyValueFactory<>("Nombre");
		columnaNombre.setCellValueFactory(factoryValueNombre);
		datos = FXCollections.observableArrayList();
		WyvernsService servicio = new WyvernsService();
		List<Wyvern> wyverns = servicio.devolverWyverns();
		datos.setAll(wyverns);
		tablaWyverns.setItems(datos);
		tablaWyverns.requestFocus();
		tablaWyverns.getSelectionModel().select(0);
		tablaWyverns.getFocusModel().focus(0);
		Wyvern wyvSeleccionado = tablaWyverns.getSelectionModel().getSelectedItem();

		Image image = new Image("/imagenes/" +wyvSeleccionado.getId() + "_Icon.png");
		imagenWyv.setImage(image);
		

	}

	@FXML
	void masInfo(ActionEvent event) {
		MasInfoController mInfoController = (MasInfoController) cambiarVistaMenu(FxmlPaths.FXML_MASINFO);
		Wyvern wyvSeleccionado = tablaWyverns.getSelectionModel().getSelectedItem();
		mInfoController.rellenarTodo(wyvSeleccionado);

	}

	@FXML
	void volver(ActionEvent event) {
		cambiarVistaMenu(FxmlPaths.FXML_MAINSCREEN);
	}

		
		
		
}