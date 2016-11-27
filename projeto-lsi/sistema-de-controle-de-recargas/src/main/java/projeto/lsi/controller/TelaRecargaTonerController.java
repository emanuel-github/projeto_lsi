package projeto.lsi.controller;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.lsi.DAO.RecargaDAO;
import projeto.lsi.DAO.TonerDao;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.RecargaBO;
import projeto.lsi.pojo.Recarga;
import projeto.lsi.pojo.Toner;

public class TelaRecargaTonerController implements Initializable{

	
    
    @FXML
    private Button botaoCancelar;
    @FXML
    private TextField campoPesoFinal;
    @FXML
    private TextField campoPesoInicial;
    @FXML
    private Button botaoRecarregar;
    @FXML
    private ComboBox<Toner> comboToner;
    ObservableList<Toner> tonerObs;

    
    
    
    public static Stage STAGE_RECARGA_TONER = new Stage();
    
    Connection connection;
    
    
    
    @FXML
	public void recarga(ActionEvent event) {
    	try {
    		String modelo = comboToner.getSelectionModel().getSelectedItem().getModelo();
        	Double preco = comboToner.getSelectionModel().getSelectedItem().getPreco();
        	Recarga recarga = new Recarga();
        	recarga.setModelo(modelo);
    		recarga.setPreco(preco);
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
    		campoPesoInicial.setText("");
    		campoPesoFinal.setText("");
    		} catch ( CampoNaoPreenchidoException | PersistenciaException e) {			
    			e.printStackTrace();
    			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    			dialogoInfo.setHeaderText(e.getMessage());
    			dialogoInfo.showAndWait();
    		}
        	

	}

    
    @FXML
   	public void cancelar(ActionEvent event){
   		TelaMenuRecargaController.STAGE_MENU_RECARGA.close();
   		
   	}
    
    
    public void preencheComboBox(){
    	List<Toner> toners = new ArrayList<>();
    	TonerDao tonerDAO = new TonerDao(connection);
    	try {
    		toners = tonerDAO.buscartodosToners();
    		tonerObs = FXCollections.observableArrayList(toners);
    	} catch (CartuchoNaoEncontradoException | PersistenciaException e) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
    	} 

    	comboToner.setItems(tonerObs);
    }

    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		preencheComboBox();
		
	}

}
