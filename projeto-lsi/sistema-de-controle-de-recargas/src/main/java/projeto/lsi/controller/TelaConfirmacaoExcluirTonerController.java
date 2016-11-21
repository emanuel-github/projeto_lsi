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
import projeto.lsi.DAO.TonerDao;
import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.Exception.TonerNaoEncontradoException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Toner;

public class TelaConfirmacaoExcluirTonerController implements Initializable{
   
	
	@FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConfirmar;
    
    
    public static Stage STAGE_CONFIRMACAO_EXCLUIR_TONER = new Stage();
    
    Connection connection;
    
    @FXML
    public void cancelar(ActionEvent envent){
    	STAGE_CONFIRMACAO_EXCLUIR_TONER.close();
    }
    
    
    
    @FXML
	public void confirmacaoExclusao(ActionEvent event) {
    	TonerDao tonerDAO = new TonerDao(connection);
		STAGE_CONFIRMACAO_EXCLUIR_TONER.close();
		try {
			tonerDAO.deletar(Toner.getToner().getIdToner());
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("TONER EXCLUIDO");
			dialogoInfo.showAndWait();
		} catch (PersistenciaException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		}catch(NullPointerException e1){
			try {
				throw new TonerNaoEncontradoException();
			} catch (TonerNaoEncontradoException e2) {
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
