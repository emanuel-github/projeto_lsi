package projeto.lsi.controller;

import java.net.URL;
import java.sql.Connection;

import java.text.SimpleDateFormat;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projeto.lsi.DAO.CartuchoDAO;
import projeto.lsi.DAO.RecargaDAO;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.RecargaBO;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Recarga;

public class TelaRecargaCartuchoController implements Initializable{

    @FXML
    private Button botaoCancelar;
    @FXML
    private TextField campoPesoFinal;
    @FXML
    private TextField campoPesoInicial;
    @FXML
    private Button botaoRecarregar;
    @FXML
    private ComboBox<Cartucho> comboCartucho;
   
    ObservableList<Cartucho> cartuchoObs;   
    
    
    
    public static Stage STAGE_RECARGA_CARTUCHO = new Stage();
    Connection connection;
    
       
    
    
    @FXML
	public void recarga(ActionEvent event) {
    	try {
    	String modelo = comboCartucho.getSelectionModel().getSelectedItem().getModelo();
    	Double preco = comboCartucho.getSelectionModel().getSelectedItem().getPreco();
    	Recarga recarga = new Recarga();
    	recarga.setModelo(modelo);
		recarga.setPreco(preco);
		recarga.setPesoInicial(Double.parseDouble(campoPesoInicial.getText()));
		recarga.setPesoFinal(Double.parseDouble(campoPesoFinal.getText()));
		RecargaBO recargaBO = new RecargaBO();
		recargaBO.verificacaoDosCampos(recarga);
		RecargaDAO recargaDAO = new RecargaDAO(connection);
		recargaDAO.cadastrarRecargaCartucho(recarga);
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
    	List<Cartucho> cartuchos = new ArrayList<>();
    	CartuchoDAO cartDAO = new CartuchoDAO(connection);
    	try {
    		cartuchos = cartDAO.buscartodosCartuchos();
    		cartuchoObs = FXCollections.observableArrayList(cartuchos);
    	} catch (CartuchoNaoEncontradoException | PersistenciaException e) {
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
    	} 

    	comboCartucho.setItems(cartuchoObs);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		preencheComboBox();
	}

}
