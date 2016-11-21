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
import projeto.lsi.DAO.RecargaDAO;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.RecargaBO;
import projeto.lsi.pojo.Recarga;

public class TelaRecargaTonerController implements Initializable{

	
    
    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoPreco;

    @FXML
    private TextField campoPesoFinal;

    @FXML
    private TextField campoModelo;

    @FXML
    private TextField campoPesoInicial;

    @FXML
    private Button botaoRecarregar;
    
    
    
    public static Stage STAGE_RECARGA_TONER = new Stage();
    
    Connection connection;
    
    
    
    @FXML
	public void recarga(ActionEvent event) {
    	try {
        	Recarga recarga = new Recarga();
        	recarga.setModelo(campoModelo.getText());
    		recarga.setPreco(Double.parseDouble(campoPreco.getText()));
    		recarga.setPesoInicial(Double.parseDouble(campoPesoInicial.getText()));
    		recarga.setPesoFinal(Double.parseDouble(campoPesoFinal.getText()));
    		RecargaBO recargaBO = new RecargaBO();
    		recargaBO.verificacaoDosCampos(recarga);
    		RecargaDAO recargaDAO = new RecargaDAO(connection);
    		recargaDAO.cadastrarRecargaToner(recarga);
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setTitle("Mensagem");
    		dialogoInfo.setHeaderText("RECARGA EFETUADA");
    		dialogoInfo.showAndWait();
    		} catch ( CampoNaoPreenchidoException | PersistenciaException e) {			
    			e.printStackTrace();
    			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    			dialogoInfo.setHeaderText(e.getMessage());
    			dialogoInfo.showAndWait();
    		}
        	

	}

    
    @FXML
   	public void cancelar(ActionEvent event){
   		STAGE_RECARGA_TONER.close();
   		
   	}
	
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
