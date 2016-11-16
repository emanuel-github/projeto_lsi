package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.LoginOuSenhaIvalidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.pojo.Usuario;

public class TelaLoginController implements Initializable{
	
	  	@FXML
	    private TextField campoLogin;

	    @FXML
	    private Button botaoEntrar;

	    @FXML
	    private Button botaoCadastrar;

	    @FXML
	    private PasswordField campoSenha;
	    
	    @FXML
	    private ImageView imagemMenuPrincipal;
	    
	    public static Stage STAGE_LOGIN = new Stage();
	    
	    public Stage stage = new Stage();
	    
	    Connection connection;
	    
	    

	    @FXML
	    public void entrarMenu(ActionEvent event) {
	    	//UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
	    	try {
				//usuarioDAO.logar(campoLogin.getText(), campoSenha.getText());
				//STAGE_LOGIN.close();
				Parent parent;				
				parent = FXMLLoader.load(getClass().getResource("../gui/MenuPrincipal.fxml"));
				Scene cena = new Scene(parent);
				MenuPrincipalController.STAGE_MENU_PRINCIPAL.setScene(cena);
				MenuPrincipalController.STAGE_MENU_PRINCIPAL.setTitle("");
				MenuPrincipalController.STAGE_MENU_PRINCIPAL.setResizable(false);
				MenuPrincipalController.STAGE_MENU_PRINCIPAL.show();		
			//} catch (LoginOuSenhaIvalidoException | PersistenciaException e1) {
			//	Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
		    //    dialogoInfo.setTitle("Mensagem");
		    //    dialogoInfo.setHeaderText(e1.getMessage());
		     //   dialogoInfo.showAndWait();
			} catch (IOException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    	
	    }
	    
 
	    
	    
	   
	    	    
	    
	    @FXML
		public void cadastrarUsuario(ActionEvent event) {
	    	STAGE_LOGIN.close();
	    	Parent parent;
			try {			
				parent = FXMLLoader.load(getClass().getResource("../gui/TelaCadastrarUsuario.fxml"));
				Scene cena = new Scene(parent);
				TelaCadastrarUsuarioController.STAGE_CADASTRAR_USUARIO.setScene(cena);
				TelaCadastrarUsuarioController.STAGE_CADASTRAR_USUARIO.setTitle("");
				TelaCadastrarUsuarioController.STAGE_CADASTRAR_USUARIO.setResizable(false);
				TelaCadastrarUsuarioController.STAGE_CADASTRAR_USUARIO.show();						
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	    
	    


		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
		}
		
		
		


}
