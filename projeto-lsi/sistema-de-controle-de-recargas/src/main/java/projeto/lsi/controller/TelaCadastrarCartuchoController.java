package projeto.lsi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastrarCartuchoController implements Initializable {
	
	   @FXML
	    private Button botaoCancelar;

	    @FXML
	    private Button botaoCadastrar;

	    @FXML
	    private TextField campoPreco;

	    @FXML
	    private TextField campoModelo;
	
	
	public static Stage STAGE_CADASTRAR_CARTUCHO = new Stage();
	
	@FXML
	public void cadastrar(ActionEvent event) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("CARTUCHO CADASTRADO");
        dialogoInfo.showAndWait();

	}
	
	@FXML
	public void cancelar(ActionEvent event){
		STAGE_CADASTRAR_CARTUCHO.close();
		
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
