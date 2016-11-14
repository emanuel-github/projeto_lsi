package projeto.lsi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaEditarCartuchoController {
	
    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoEditar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoModelo;
    
    
    public static Stage STAGE_EDITAR_CARTUCHO = new Stage();
    
    
    
    @FXML
   	public void editar(ActionEvent event) {
   		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
           dialogoInfo.setTitle("Mensagem");
           dialogoInfo.setHeaderText("CARTUCHO EDITADO COM SUCESSO");
           dialogoInfo.showAndWait();

   	}
       
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_EDITAR_CARTUCHO.close();						
	}


}