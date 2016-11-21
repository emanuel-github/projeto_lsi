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
import projeto.lsi.DAO.TonerDao;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.Exception.TonerNaoEncontradoException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Toner;

public class TelaPesquisarTonerController implements Initializable{
	
    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoCancelar;

    @FXML
    private ListView<Toner> listViewResultadosPesquisa;

    @FXML
    private Button botaoConsultar;

    @FXML
    private TextField campoPesquisa;

    @FXML
    private Button botaoEditar;
	
	
	public static Stage STAGE_PESQUISA_TONER = new Stage();
	
	private ObservableList<Toner> obsToner;
	
	Connection connection;
	
	
	 @FXML
	 public void consultarToner(ActionEvent event) {
		 TonerDao tonerDAO = new TonerDao(connection);
		 try {
			 List<Toner> toners = tonerDAO.buscarToner(campoPesquisa.getText());
			 obsToner = FXCollections.observableArrayList(toners);		 
			 listViewResultadosPesquisa.setItems( obsToner);			 
		} catch (PersistenciaException | TonerNaoEncontradoException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		} 
	 }
	 
	
	
	 @FXML
	 public void editarToner(ActionEvent event) {
		 try {
			 Toner.toner.setToner(listViewResultadosPesquisa.getSelectionModel().getSelectedItem());
			 Parent parent;
			 parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaEditarToner.fxml"));
			 Scene cena = new Scene(parent);
			 TelaEditarTonerController.STAGE_EDITAR_TONER.setScene(cena);
			 TelaEditarTonerController.STAGE_EDITAR_TONER.setTitle("");
			 TelaEditarTonerController.STAGE_EDITAR_TONER.setResizable(false);
			 TelaEditarTonerController.STAGE_EDITAR_TONER.show();						
		 } catch (IOException |  NullPointerException e) {
			 try {
				 throw new TonerNaoEncontradoException();
			 } catch (TonerNaoEncontradoException e1) {
				 Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				 dialogoInfo.setHeaderText(e1.getMessage());
				 dialogoInfo.showAndWait();
			 }
		 }

	 }

	
	
	
	public void excluirToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaConfirmacaoExcluirToner.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setScene(cena);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setTitle("");
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setResizable(false);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}
		Toner.toner= listViewResultadosPesquisa.getSelectionModel().getSelectedItem();
		listViewResultadosPesquisa.getItems().remove(Toner.toner);		

	}
	
	
	@FXML
	public void cancelar(ActionEvent event) {
    	STAGE_PESQUISA_TONER.close();
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
