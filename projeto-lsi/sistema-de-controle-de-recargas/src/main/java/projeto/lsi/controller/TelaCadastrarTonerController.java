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

public class TelaCadastrarTonerController implements Initializable{

	
    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoModelo;
    
    Connection connection;
    
    
    
    
    public static Stage STAGE_CADASTRAR_TONER = new Stage();
    
    
    
    @FXML
	public void cadastrar(ActionEvent event) {
    	try {
			Toner toner = new Toner();
			toner.setModelo(campoModelo.getText());
			toner.setPreco(Double.parseDouble(campoPreco.getText()));
			TonerBO ton = new TonerBO();
			ton.verificacaoDosCampos(toner);
			TonerDao tonerDAO = new TonerDao(connection);
			tonerDAO.cadastrar(toner);
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("TONER CADASTRADO");
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
		STAGE_CADASTRAR_TONER.close();
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
