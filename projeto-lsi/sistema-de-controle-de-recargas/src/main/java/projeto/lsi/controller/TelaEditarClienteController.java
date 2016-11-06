package projeto.lsi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
