package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaMenuRecargaController implements Initializable{
	
    @FXML
    private Button botaoToner;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoCartucho;
	
    
    
    public static Stage STAGE_MENU_RECARGA = new Stage();
    
    
    
    @FXML
	public void cartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaRecargaCartucho.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_RECARGA.setScene(cena);
			STAGE_MENU_RECARGA.setTitle("");
			STAGE_MENU_RECARGA.setResizable(false);
			STAGE_MENU_RECARGA.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    @FXML
	public void toner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaRecargaToner.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_RECARGA.setScene(cena);
			STAGE_MENU_RECARGA.setTitle("");
			STAGE_MENU_RECARGA.setResizable(false);
			STAGE_MENU_RECARGA.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    @FXML
    public void cancelar(ActionEvent envent){
    	STAGE_MENU_RECARGA.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
