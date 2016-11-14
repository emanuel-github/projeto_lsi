package projeto.lsi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaConfirmacaoExcluirCartuchoController implements Initializable {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConfirmar;

	
    
    public static Stage STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO = new Stage();
	
    @FXML
    public void cancelar(ActionEvent envent){
    	STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.close();
    }
    
    
    @FXML
	public void confirmacaoExclusao(ActionEvent event) {
		STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.close();
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("CARTUCHO EXCLUIDO");
        dialogoInfo.showAndWait();

	}
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
