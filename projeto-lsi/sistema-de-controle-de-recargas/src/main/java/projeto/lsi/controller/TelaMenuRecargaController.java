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
			TelaRecargaCartuchoController.STAGE_RECARGA_CARTUCHO.setScene(cena);
			TelaRecargaCartuchoController.STAGE_RECARGA_CARTUCHO.setTitle("");
			TelaRecargaCartuchoController.STAGE_RECARGA_CARTUCHO.setResizable(false);
			TelaRecargaCartuchoController.STAGE_RECARGA_CARTUCHO.show();						
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
			TelaRecargaTonerController.STAGE_RECARGA_TONER.setScene(cena);
			TelaRecargaTonerController.STAGE_RECARGA_TONER.setTitle("");
			TelaRecargaTonerController.STAGE_RECARGA_TONER.setResizable(false);
			TelaRecargaTonerController.STAGE_RECARGA_TONER.show();						
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
