package projeto.lsi.gui;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import projeto.lsi.controller.TelaLoginController;
;

public class Teste extends Application{
	
	public static Scene SCENE;


	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent;
		parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		SCENE = new Scene(parent);
		TelaLoginController.STAGE_LOGIN.setScene(SCENE);
		TelaLoginController.STAGE_LOGIN.setTitle("");
		TelaLoginController.STAGE_LOGIN.setResizable(false);
		TelaLoginController.STAGE_LOGIN.show();		
	}
	
	
	
	
	




public static void main(String[] args) {
	launch(args);

}	

		
	}

