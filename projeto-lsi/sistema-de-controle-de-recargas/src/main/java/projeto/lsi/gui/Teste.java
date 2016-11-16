package projeto.lsi.gui;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projeto.lsi.controller.TelaLoginController;
;

public class Teste extends Application{
	
	
	

	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));
		Scene cena = new Scene(parent);
		TelaLoginController.STAGE_LOGIN.setScene(cena);
		TelaLoginController.STAGE_LOGIN.setTitle("");
		TelaLoginController.STAGE_LOGIN.setResizable(false);
		TelaLoginController.STAGE_LOGIN.show();
		
	}
	
	
	
	
	




public static void main(String[] args) {
	launch(args);

}	

		
	}

