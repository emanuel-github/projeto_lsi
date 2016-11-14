package projeto.lsi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class TelaConfirmacaoExcluirClienteController implements Initializable {


	public static Stage STAGE_EXCLUIR_CLIENTE = new Stage();
	
	
	@FXML
	public void cancelar(ActionEvent event) {
		STAGE_EXCLUIR_CLIENTE.close();						
	}
	
	@FXML
	public void confirmacaoExclusao(ActionEvent event) {
		STAGE_EXCLUIR_CLIENTE.close();
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("CLIENTE EXCLUIDO");
        dialogoInfo.showAndWait();

	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
