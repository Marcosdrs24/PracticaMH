package app.controllers;

import app.modelo.Wyvern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MasInfoController extends AppController {
	@FXML
	private Button btnMasInfo;

	@FXML
	public Button btnVolver;

	@FXML
	public ImageView imgWyv;

	@FXML
	public Text descripcionWyv;

	@FXML
	private Text nombreWyv;

	public Wyvern wyvSeleccionado;

	@FXML
	void volverALista(ActionEvent event) {
		cambiarVistaMenu(FxmlPaths.FXML_LISTADO);

	}

	@FXML
	void ampliarInfo(ActionEvent event) {
		InfoAmpliadaController mInfoController = (InfoAmpliadaController) cambiarVistaMenu(FxmlPaths.FXML_AMPLIAR);
		mInfoController.rellenarTodo(wyvSeleccionado);

	}

	public void rellenarTodo(Wyvern seleccionado) {
		wyvSeleccionado = seleccionado;
		descripcionWyv.setText(seleccionado.getDescripición());
		if(seleccionado.getDescripición()== null) {
			descripcionWyv.setText("\"No hay decripción para este wyvern\"");
		}
		
		Image imagen;
		if (seleccionado.getId().equals("WN1") || seleccionado.getId().equals("WN2")|| seleccionado.getId().equals("WN3") || seleccionado.getId().equals("WN4")|| seleccionado.getId().equals("WN5")) {
			imagen = new Image("/imagenes/Unknown.png");
			
		}else {
			imagen = new Image("/imagenes/" + seleccionado.getId() + "_render.png");
		}
		imgWyv.setImage(imagen);
		nombreWyv.setText(seleccionado.getNombre());
	}
}