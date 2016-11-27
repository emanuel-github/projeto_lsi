package projeto.lsi.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projeto.lsi.DAO.EstatisticasDAO;
import projeto.lsi.Exception.NaoExisteRecargaNoIntervaloException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Recarga;

public class TelaEstatisticasTonerController {
	
	
    @FXML
    private Button botaoCancelar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;
    
    
    @FXML
    private ListView<Recarga> listViewRecargaToner;
    
    
    @FXML
    private Text texto;
    
    @FXML
    private Label totalRecargasToner;
    
    private ObservableList<Recarga> obsToner;
    
    Connection connection;
    
    
public static Stage STAGE_ESTATISTICAS_TONER = new Stage();

	
    @FXML
    public void cancelar(ActionEvent event){
    	STAGE_ESTATISTICAS_TONER.close();
    	
    }
    
    
    
    @FXML
    public void mostrarRecargasToner(ActionEvent event){
    	int soma;
    	List<Recarga> recargas = new ArrayList<>();
    	EstatisticasDAO estatistica = new EstatisticasDAO(connection);
    	try {
    		recargas = estatistica.exibeRecargasToner(dataInicial.getValue(), dataFinal.getValue());
    		obsToner = FXCollections.observableArrayList(recargas);		 
    		listViewRecargaToner.setItems( obsToner);	
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


}
