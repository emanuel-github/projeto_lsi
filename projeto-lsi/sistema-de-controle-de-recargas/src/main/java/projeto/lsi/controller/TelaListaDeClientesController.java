package projeto.lsi.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.DAO.EstatisticasDAO;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.ClientesNaoCadastradosException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cliente;

public class TelaListaDeClientesController implements Initializable{
	
    @FXML
    private ListView<Cliente> listaClientes;
    
    Connection connection;
    
    private ObservableList<Cliente> obsCliente;
    
    
    public void exibirClientes() {
		 EstatisticasDAO estatisticas = new EstatisticasDAO(connection);
		 try {
			 List<Cliente> clientes = estatisticas.listarClientes();
			 obsCliente = FXCollections.observableArrayList(clientes);		 
			 listaClientes.setItems(obsCliente);
			 
		} catch ( PersistenciaException | ClientesNaoCadastradosException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		} 

	 }
    
    
   
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		exibirClientes();
		
		
	} 

}


