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
import projeto.lsi.DAO.TonerDao;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.CartuchoBO;
import projeto.lsi.logica.TonerBO;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Toner;

public class TelaEditarTonerController implements Initializable {
	
    @FXML
    private Button botaoCancelar;

   
    @FXML
    private Button botaoEditar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoModelo;

    public static Stage STAGE_EDITAR_TONER = new Stage();
    
    Connection connection;
    
    @FXML
   	public void editar(ActionEvent event) {
    	try {
    		Toner toner = new Toner();
    		toner.setIdToner(Toner.toner.getIdToner());
    		toner.setModelo(campoModelo.getText());
    		toner.setPreco(Double.parseDouble(campoPreco.getText()));
    		TonerBO tonerBO = new TonerBO();
    		tonerBO.verificacaoDosCampos(toner);
    		TonerDao tonerDAO = new TonerDao(connection);
    		tonerDAO.atualizar(toner);
    		TelaPesquisarTonerController.STAGE_PESQUISA_TONER.close();
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setTitle("Mensagem");
    		dialogoInfo.setHeaderText("TONER EDITADO COM SUCESSO");
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
       	STAGE_EDITAR_TONER.close();						
   	}
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoModelo.setText(Toner.getToner().getModelo());
		campoPreco.setText(String.valueOf(Toner.getToner().getPreco()));
		
		
	}

}
