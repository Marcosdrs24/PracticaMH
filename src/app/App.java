package app;





import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import app.controllers.AppController;
import app.controllers.FxmlPaths;
import app.services.WyvernsService;
import javafx.application.Application;
import javafx.stage.Stage;



public class App extends Application {
	private final static Logger log = LogManager.getLogger(App.class);
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.setProperty("log4j.configurationFile", "/config/log4j.properties");
		
		
		
		primaryStage.setResizable(false);
		AppController controller = new AppController(primaryStage);
		controller.cambiarVista(FxmlPaths.FXML_LOGIN);
		primaryStage.show();
		WyvernsService service = new WyvernsService();
		service.dropColecciones();
		WyvernsService.crearLaLista();
		log.log(Level.INFO,("Creando la lista"));
		
		
		
		
				
	}
	public static void main(String[] args) {
		launch();
	}
	
	
	

}
