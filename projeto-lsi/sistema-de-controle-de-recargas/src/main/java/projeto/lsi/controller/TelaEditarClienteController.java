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

public class TelaEditarClienteController implements Initializable{

	@FXML
    private TextField campoTelefone;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private Button botaoEditar;
    
    public static Stage STAGE_EDITAR_CLIENTE = new Stage();
    
    @FXML
	public void editar(ActionEvent event) {
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("CLIENTE EDITADO COM SUCESSO");
        dialogoInfo.showAndWait();

	}
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_EDITAR_CLIENTE.close();						
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
