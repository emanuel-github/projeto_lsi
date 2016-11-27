package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.EmailInvalidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.logica.UsuarioBO;
import projeto.lsi.pojo.Usuario;

public class TelaCadastrarUsuarioController implements Initializable{
	@FXML
    private TextField campoLogin;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private PasswordField campoSenha;
    
    
    public static Stage STAGE_CADASTRAR_USUARIO = new Stage();
    Connection connection;
    
    
    
    @FXML
	public void cancelar(ActionEvent event) {
		STAGE_CADASTRAR_USUARIO.close();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaLogin.fxml"));
			Scene cena = new Scene(parent);
			TelaLoginController.STAGE_LOGIN.setScene(cena);
			TelaLoginController.STAGE_LOGIN.setTitle("");
			TelaLoginController.STAGE_LOGIN.setResizable(false);
			TelaLoginController.STAGE_LOGIN.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
    
    @FXML
    public void cadastrar(ActionEvent event) {
    	Usuario usuario = new Usuario();
    	usuario.setNome(campoNome.getText());
    	usuario.setEmail(campoEmail.getText());
    	usuario.setLogin(campoLogin.getText());
    	usuario.setSenha(campoSenha.getText());
    	UsuarioBO usuarioBO = new UsuarioBO();
    	try {
    		usuarioBO.verificacaoDosCampos(usuario);
    		UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
    		usuarioDAO.cadastrar(usuario);
    		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
    		dialogoInfo.setTitle("Mensagem");
    		dialogoInfo.setHeaderText("USUARIO CADASTRADO");
    		dialogoInfo.showAndWait();
    		STAGE_CADASTRAR_USUARIO.close();
    		Parent parent;
    		parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaLogin.fxml"));
    		Scene cena = new Scene(parent);
    		TelaLoginController.STAGE_LOGIN.setScene(cena);
    		TelaLoginController.STAGE_LOGIN.setTitle("");
    		TelaLoginController.STAGE_LOGIN.setResizable(false);
    		TelaLoginController.STAGE_LOGIN.show();
    	} catch (CampoNaoPreenchidoException | PersistenciaException |IOException | EmailInvalidoException e1) {
    		Alert dialogo = new Alert(Alert.AlertType.INFORMATION);
    		dialogo.setTitle("Mensagem");
    		dialogo.setHeaderText(e1.getMessage());
    		dialogo.showAndWait();

    	} 


    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
