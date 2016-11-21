package projeto.lsi.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import projeto.lsi.DAO.CartuchoDAO;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Cartucho;

public class TelaConfirmacaoExcluirCartuchoController implements Initializable {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConfirmar;
    
    Connection connection;

	
    
    public static Stage STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO = new Stage();
	
    @FXML
    public void cancelar(ActionEvent envent){
    	STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.close();
    }
    
    
    @FXML
	public void confirmacaoExclusao(ActionEvent event) {
    	CartuchoDAO cartuchoDAO = new CartuchoDAO(connection);
    	STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.close();
    	try {
			cartuchoDAO.deletar(Cartucho.getCartucho().getIdCartucho());
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("CARTUCHO EXCLUIDO");
			dialogoInfo.showAndWait();
		} catch (PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		}catch(NullPointerException e1){
			try {
				throw new CartuchoNaoEncontradoException();
			} catch (CartuchoNaoEncontradoException e2) {
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				dialogoInfo.setHeaderText(e2.getMessage());
				dialogoInfo.showAndWait();
			}
		}

	}
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
