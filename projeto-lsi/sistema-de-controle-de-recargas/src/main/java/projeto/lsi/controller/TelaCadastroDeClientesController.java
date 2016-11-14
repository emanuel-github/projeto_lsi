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

public class TelaCadastroDeClientesController implements Initializable{
	
	  	@FXML
	    private Button botaoCancelar;

	    @FXML
	    private Button botaoCadastrar;

	    @FXML
	    private TextField campoEmailCliente;

	    @FXML
	    private TextField campoNomeCliente;

	    @FXML
	    private TextField campoTelefoneCliente;

	    @FXML
	    private TextField campoCpfCliente;
	    
	    
	    public static Stage STAGE_CADASTRO_CLIENTE = new Stage();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	@FXML
	public void cancelar(ActionEvent event) {
		TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.close();

	}
	
	
	@FXML
	public void cadastrar(ActionEvent event) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("CLIENTE CADASTRADO");
        dialogoInfo.showAndWait();

	}

}
