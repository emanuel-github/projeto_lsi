package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cliente;
import projeto.lsi.pojo.Usuario;

public class TelaConfirmacaoExcluirClienteController implements Initializable {


	public static Stage STAGE_EXCLUIR_CLIENTE = new Stage();
	Connection connection;
	
	
	@FXML
	public void cancelar(ActionEvent event) {
		STAGE_EXCLUIR_CLIENTE.close();						
	}
	
	@FXML
	public void confirmacaoExclusao(ActionEvent event) {
		ClienteDAO cli = new ClienteDAO(connection);
		try {
			STAGE_EXCLUIR_CLIENTE.close();
			cli.deletar(Cliente.getCliente().getIdCliente());
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("CLIENTE EXCLUÍDO");
			dialogoInfo.showAndWait();

		} catch (PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		} catch(NullPointerException e1){
			try {
				throw new ClienteNaoEncontradoException();
			} catch (ClienteNaoEncontradoException e2) {
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				dialogoInfo.setHeaderText(e2.getMessage());
				dialogoInfo.showAndWait();
			}
		}
	}
		
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
