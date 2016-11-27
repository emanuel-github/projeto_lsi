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
import projeto.lsi.DAO.CartuchoDAO;
import projeto.lsi.DAO.ClienteDAO;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.CartuchoBO;
import projeto.lsi.logica.ClienteBO;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;

public class TelaCadastrarCartuchoController implements Initializable {
	
	   @FXML
	    private Button botaoCancelar;

	    @FXML
	    private Button botaoCadastrar;

	    @FXML
	    private TextField campoPreco;

	    @FXML
	    private TextField campoModelo;
	    
	    Connection connection;
	
	
	public static Stage STAGE_CADASTRAR_CARTUCHO = new Stage();
	
	@FXML
	public void cadastrar(ActionEvent event) {
		try {
			Cartucho cartucho = new Cartucho();
			cartucho.setModelo(campoModelo.getText());
			cartucho.setPreco(Double.parseDouble(campoPreco.getText()));
			CartuchoBO cart = new CartuchoBO();
			cart.verificacaoDosCampos(cartucho);
			CartuchoDAO cartuchoDAO = new CartuchoDAO(connection);
			cartuchoDAO.cadastrar(cartucho);
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("CARTUCHO CADASTRADO");
			dialogoInfo.showAndWait();
			campoModelo.setText("");
			campoPreco.setText("");
		} catch (CampoNaoPreenchidoException | PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		}

	}

	
	
	@FXML
	public void cancelar(ActionEvent event){
		TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.close();
		
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
