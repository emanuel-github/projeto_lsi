package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

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
import projeto.lsi.DAO.CartuchoDAO;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;

public class TelaPesquisarCartuchoController implements Initializable {

	
    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoCancelar;

    @FXML
    private ListView<Cartucho> listViewResultadosPesquisa;

    @FXML
    private Button botaoConsultar;

    @FXML
    private TextField campoPesquisa;

    @FXML
    private Button botaoEditar;
    
      
    public static Stage STAGE_PESQUISA_CARTUCHO = new Stage();
    
    private ObservableList<Cartucho> obsCartucho;
    
    Connection connection;
    
    @FXML
    public void consultarCartucho(ActionEvent event) {
    	CartuchoDAO cartucho = new CartuchoDAO(connection);
		 try {
			 List<Cartucho> cartuchos = cartucho.buscarCartucho(campoPesquisa.getText());
			 obsCartucho = FXCollections.observableArrayList(cartuchos);		 
			 listViewResultadosPesquisa.setItems( obsCartucho);			 
		} catch (PersistenciaException | CartuchoNaoEncontradoException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		} 

	 }

    
    
    @FXML
	public void editarCartucho(ActionEvent event) {
		try {
			Cartucho.cartucho.setCartucho(listViewResultadosPesquisa.getSelectionModel().getSelectedItem());
			Parent parent;
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaEditarCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setScene(cena);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setTitle("");
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setResizable(false);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.show();						
		} catch (IOException |  NullPointerException e) {
			 try {
				 throw new CartuchoNaoEncontradoException();
			 } catch (CartuchoNaoEncontradoException e1) {
				 Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				 dialogoInfo.setHeaderText(e1.getMessage());
				 dialogoInfo.showAndWait();
			 }
		 }

	}
    
    
    
    public void excluirCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaConfirmacaoExcluirCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setScene(cena);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setTitle("");
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setResizable(false);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}
		Cartucho.cartucho= listViewResultadosPesquisa.getSelectionModel().getSelectedItem();
		listViewResultadosPesquisa.getItems().remove(Cartucho.cartucho);		

	}
    
    
    
    
    
    @FXML
	public void cancelar(ActionEvent event) {
    	TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.close();
    }
    
    
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
