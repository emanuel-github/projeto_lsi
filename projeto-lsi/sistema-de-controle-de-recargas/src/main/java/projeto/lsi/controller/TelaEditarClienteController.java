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
import projeto.lsi.Exception.CpfInvalidoException;
import projeto.lsi.Exception.EmailInvalidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.ClienteBO;
import projeto.lsi.pojo.Cliente;


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
    
    Connection connection;
    
    @FXML
    public void editar(ActionEvent event) {
    	try {
    		Cliente cliente = new Cliente();
    		cliente.setIdCliente(Cliente.cliente.getIdCliente());
    		cliente.setNome(campoNome.getText());
    		cliente.setCpf(campoCpf.getText());
    		cliente.setEmail(campoEmail.getText());
    		cliente.setTelefone(campoTelefone.getText());
    		ClienteBO clienteBO = new ClienteBO();
    		clienteBO.verificacaoDosCampos(cliente);
    		ClienteDAO clienteDAO = new ClienteDAO(connection);
    		clienteDAO.atualizar(cliente);
    		TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.close();
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setTitle("Mensagem");
    		dialogoInfo.setHeaderText("CLIENTE EDITADO COM SUCESSO");
    		dialogoInfo.showAndWait();
    		campoNome.setText("");
    		campoCpf.setText("");
    		campoEmail.setText("");
    		campoTelefone.setText("");    		
    	} catch (PersistenciaException | CampoNaoPreenchidoException | CpfInvalidoException | EmailInvalidoException e) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setHeaderText(e.getMessage());
    		dialogoInfo.showAndWait();
    	}


    }
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_EDITAR_CLIENTE.close();						
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	//	TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.close();	
		campoNome.setText(Cliente.getCliente().getNome());
		campoCpf.setText(Cliente.getCliente().getCpf());
		campoEmail.setText(Cliente.getCliente().getEmail());
		campoTelefone.setText(Cliente.getCliente().getTelefone());
		
	}

}
