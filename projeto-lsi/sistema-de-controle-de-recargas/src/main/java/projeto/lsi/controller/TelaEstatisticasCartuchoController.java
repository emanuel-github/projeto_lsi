package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projeto.lsi.DAO.EstatisticasDAO;
import projeto.lsi.DAO.RecargaDAO;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.NaoExisteRecargaNoIntervaloException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Recarga;

public class TelaEstatisticasCartuchoController implements Initializable {

	
    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConsultar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;
    
    @FXML
    private ListView<Recarga> listViewRecargasCartucho;
    
    
   
    
    @FXML
    private Label labelTotalRecargas;
    
    @FXML
    private Text texto;

    
    private ObservableList<Recarga> obsCartucho;
    
    
    public static Stage STAGE_ESTATISTICAS_CARTUCHO = new Stage();
    
    Connection connection;

	
    @FXML
    public void cancelar(ActionEvent event){
    	STAGE_ESTATISTICAS_CARTUCHO.close();
    	
    }
    
    
    
    @FXML
    public void mostrarRecargasCartucho(ActionEvent event){
    	int soma;
    	List<Recarga> recargas = new ArrayList<>();
    	EstatisticasDAO estatistica = new EstatisticasDAO(connection);
    	try {
    		recargas = estatistica.exibeRecargasCartucho(dataInicial.getValue(), dataFinal.getValue());
    		obsCartucho = FXCollections.observableArrayList(recargas);		 
    		listViewRecargasCartucho.setItems( obsCartucho);
    		soma = recargas.size();
    		texto.setText(String.valueOf(soma));
    		
    	} catch (NullPointerException e) {
    		try {
    			throw new NaoExisteRecargaNoIntervaloException();
    		} catch (NaoExisteRecargaNoIntervaloException e2) {
    			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    			dialogoInfo.setHeaderText(e2.getMessage());
    			dialogoInfo.showAndWait();
    		}

    	}catch (NaoExisteRecargaNoIntervaloException | PersistenciaException e1) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setHeaderText(e1.getMessage());
    		dialogoInfo.showAndWait();
    	}

    }


    	
    
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	

}
