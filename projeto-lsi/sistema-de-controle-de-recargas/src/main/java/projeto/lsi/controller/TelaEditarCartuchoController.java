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

public class TelaEditarCartuchoController implements Initializable {
	
    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoEditar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoModelo;
    
    
    public static Stage STAGE_EDITAR_CARTUCHO = new Stage();
    
    Connection connection;
    
    @FXML
   	public void editar(ActionEvent event) {
    	try {
    		Cartucho cartucho = new Cartucho();
    		cartucho.setIdCartucho(Cartucho.cartucho.getIdCartucho());
    		cartucho.setModelo(campoModelo.getText());
    		cartucho.setPreco(Double.parseDouble(campoPreco.getText()));
    		CartuchoBO cartuchoBO = new CartuchoBO();
    		cartuchoBO.verificacaoDosCampos(cartucho);
    		CartuchoDAO cartuchoDAO = new CartuchoDAO(connection);
    		cartuchoDAO.atualizar(cartucho);
    		TelaPesquisarCartuchoController.STAGE_PESQUISA_CARTUCHO.close();
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setTitle("Mensagem");
    		dialogoInfo.setHeaderText("CARTUCHO EDITADO COM SUCESSO");
    		dialogoInfo.showAndWait();
    		campoModelo.setText("");
    		campoPreco.setText("");
    	} catch (PersistenciaException | CampoNaoPreenchidoException e) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setHeaderText(e.getMessage());
    		dialogoInfo.showAndWait();
    	}

   	}
       
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_EDITAR_CARTUCHO.close();						
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoModelo.setText(Cartucho.getCartucho().getModelo());
		campoPreco.setText(String.valueOf(Cartucho.getCartucho().getPreco()));
		
	}


}
