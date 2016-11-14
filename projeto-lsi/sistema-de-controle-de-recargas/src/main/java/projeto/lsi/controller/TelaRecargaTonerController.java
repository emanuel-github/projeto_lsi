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

public class TelaRecargaTonerController implements Initializable{

	
    @FXML
    private TextField campoData;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoPesoFinal;

    @FXML
    private TextField campoModelo;

    @FXML
    private TextField campoPesoInicial;

    @FXML
    private Button botaoRecarregar;
    
    
    
    public static Stage STAGE_RECARGA_TONER = new Stage();
    
    
    
    @FXML
	public void recarga(ActionEvent event) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("TONER RECARREGADO");
        dialogoInfo.showAndWait();

	}

    
    @FXML
   	public void cancelar(ActionEvent event){
   		STAGE_RECARGA_TONER.close();
   		
   	}
	
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
