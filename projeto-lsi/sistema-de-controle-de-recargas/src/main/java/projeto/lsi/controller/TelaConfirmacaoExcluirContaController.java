package projeto.lsi.controller;

import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Usuario;

public class TelaConfirmacaoExcluirContaController {
	
	
	 public static Stage STAGE_EXCLUIR_USUARIO = new Stage();
	 
	 
	    @FXML
	    private Button botaoCancelar;

	    @FXML
	    private Button botaoConfirmar;
	    
	    Connection connection;

	    
	    @FXML
		public void cancelar(ActionEvent event) {
			STAGE_EXCLUIR_USUARIO.close();

		}
	    
	    
	    @FXML
	    public void excluirUsuario(ActionEvent event) {
	    	UsuarioDAO usu = new UsuarioDAO(connection);
	    	try {
				usu.deletar(Usuario.getUsuario().getIdUsuario());
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				dialogoInfo.setTitle("Mensagem");
				dialogoInfo.setHeaderText("USU�RIO EXCLU�DO");
				dialogoInfo.showAndWait();
				System.exit(0);
				
			} catch (PersistenciaException e) {
				Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
				dialogoInfo.setHeaderText(e.getMessage());
				dialogoInfo.showAndWait();
			}

	    }
	    
	    
	    

}
