package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.ItemNaoSelecionadoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cliente;

public class TelaPesquisaClienteController implements Initializable{

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoCancelar;

    @FXML
    public ListView<Cliente> listViewResultadosPesquisa;

    @FXML
    private Button botaoConsultar;

    @FXML
    private TextField campoPesquisa;

    @FXML
    private Button botaoEditar;
	
    
    public static Stage STAGE_PESQUISA_CLIENTE = new Stage();
    
    Connection connection;
    
    private ObservableList<Cliente> obsCliente;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	 @FXML
	 void consultarCliente(ActionEvent event) {
		 ClienteDAO cliente = new ClienteDAO(connection);
		 try {
			 List<Cliente> clientes = cliente.buscarCliente(campoPesquisa.getText());
			 obsCliente = FXCollections.observableArrayList(clientes);		 
			 listViewResultadosPesquisa.setItems(obsCliente);
			 
		} catch (ClienteNaoEncontradoException | PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		} 

	 }
	 
	 
	 @FXML
	 public void editarCliente(ActionEvent event) {
		 try {			

			 Cliente.cliente.setCliente(listViewResultadosPesquisa.getSelectionModel().getSelectedItem());
			 Parent parent;
			 parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaEditarCliente.fxml"));
			 Scene cena = new Scene(parent);
			 TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setScene(cena);
			 TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setTitle("");
			 TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setResizable(false);
			 TelaEditarClienteController.STAGE_EDITAR_CLIENTE.show();						
		 } catch (IOException |  NullPointerException e) {
			 try {
				 throw new ClienteNaoEncontradoException();
			 } catch (ClienteNaoEncontradoException e1) {
				 Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				 dialogoInfo.setHeaderText(e1.getMessage());
				 dialogoInfo.showAndWait();
			 }
		 }

	 }

	@FXML
	public void excluirCliente(ActionEvent event) {		
		try {			
			Parent parent;
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaConfirmacaoExcluirCliente.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setScene(cena);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setTitle("");
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setResizable(false);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}
		Cliente.cliente= listViewResultadosPesquisa.getSelectionModel().getSelectedItem();
		listViewResultadosPesquisa.getItems().remove(Cliente.cliente);		

	}
	
	@FXML
	public void cancelar(ActionEvent event) {
		TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.close();						
	}

}
