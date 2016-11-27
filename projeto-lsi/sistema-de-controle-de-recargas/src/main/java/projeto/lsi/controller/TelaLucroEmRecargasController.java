package projeto.lsi.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projeto.lsi.DAO.EstatisticasDAO;
import projeto.lsi.Exception.NaoExisteRecargaNoIntervaloException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Recarga;

public class TelaLucroEmRecargasController implements Initializable {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConsultar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;
    
    
    
    @FXML
    private Label labelLucroTotal;

    @FXML
    private Text textRecCart;

    @FXML
    private Label labelREcToner;

    
    @FXML
    private Label labelRecCartuchos;

    @FXML
    private Text textTotal;
    
    @FXML
    private Text textRecToner;
    
    @FXML
    private Text textQtdRecCartucho;

    @FXML
    private Text textQtdRecToner;

    @FXML
    private Label labelQuantidade;
    
    @FXML
    private Text TextTotalRecargas;

    
    public static Stage STAGE_LUCRO_RECARGAS = new Stage();
    
    
    Connection connection;

	
    @FXML
    public void cancelar(ActionEvent event){
    	STAGE_LUCRO_RECARGAS.close();
    	
    }

    @FXML
    void mostrarLucro(ActionEvent event) {
    	Double somaLucroCartucho = 0.0;
    	Double somaLucroToner = 0.0;
    	Double somaTotal = 0.0;
    	int somaQtdRecCartucho = 0;
    	int somaQtdRecToner = 0;
    	int somaQtdTotalRecargas = 0;
    	List<Double> listaRecCartucho = new ArrayList<>();
    	List<Double> listaRecToner = new ArrayList<>();
    	EstatisticasDAO estatistica = new EstatisticasDAO(connection);
    	try {
    		listaRecCartucho = estatistica.lucroTotalRecargasCartucho(dataInicial.getValue(), dataFinal.getValue());
    		listaRecToner = estatistica.lucroTotalRecargasToner(dataInicial.getValue(), dataFinal.getValue());
    		for (int i = 0; i < listaRecCartucho.size(); i++) {
    			somaLucroCartucho = somaLucroCartucho + listaRecCartucho.get(i);
    		}
    		for (int i = 0; i < listaRecToner.size(); i++) {
    			somaLucroToner = somaLucroToner + listaRecToner.get(i);
    		}
    		somaTotal = somaLucroCartucho + somaLucroToner;
    		somaQtdRecCartucho = listaRecCartucho.size();
    		somaQtdRecToner = listaRecToner.size();
    		somaQtdTotalRecargas = somaQtdRecCartucho + somaQtdRecToner;
    		textRecCart.setText( "R$ " + String.valueOf(somaLucroCartucho));
    		textRecToner.setText("R$ " + String.valueOf(somaLucroToner));
    		textTotal.setText("R$ " + String.valueOf(somaTotal));    		
    		textQtdRecCartucho.setText(String.valueOf(somaQtdRecCartucho));
    		textQtdRecToner.setText(String.valueOf(somaQtdRecToner));
    		TextTotalRecargas.setText(String.valueOf(somaQtdTotalRecargas));

    	} catch (NullPointerException e) {
    		try {
    			throw new NaoExisteRecargaNoIntervaloException();
    		} catch (NaoExisteRecargaNoIntervaloException e2) {
    			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    			dialogoInfo.setHeaderText(e2.getMessage());
    			dialogoInfo.showAndWait();
    		}

    	}catch (PersistenciaException e1) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setHeaderText(e1.getMessage());
    		dialogoInfo.showAndWait();
    	}

    }




	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
