package projeto.lsi.controller;


import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.ClienteBO;
import projeto.lsi.pojo.Cliente;

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
	    
	    Connection connection;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	@FXML
	public void cancelar(ActionEvent event) {
		TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.close();

	}
	
	
	@FXML
	public void cadastrar(ActionEvent event) {
		try {
		Cliente cli = new Cliente();
		cli.setNome(campoNomeCliente.getText());
		cli.setCpf(campoCpfCliente.getText());
		cli.setEmail(campoEmailCliente.getText());
		cli.setTelefone(campoTelefoneCliente.getText());
		ClienteBO cliente = new ClienteBO();
		cliente.verificacaoDosCampos(cli);
		ClienteDAO clienteDAO = new ClienteDAO(connection);
		clienteDAO.cadastrar(cli);
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
		dialogoInfo.setTitle("Mensagem");
		dialogoInfo.setHeaderText("CLIENTE CADASTRADO");
		dialogoInfo.showAndWait();
		campoNomeCliente.setText("");
		campoCpfCliente.setText("");
		campoEmailCliente.setText("");
		campoTelefoneCliente.setText("");
		} catch (CampoNaoPreenchidoException | PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		}

	}

}
