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

public class TelaEditarUsuarioController implements Initializable{
	
    @FXML
    private TextField campoLogin;

    @FXML
    private Button botaoCancelar;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNome;

    @FXML
    private Button botaoExcluirConta;

    @FXML
    private Button botaoEditar;

    @FXML
    private PasswordField campoSenha;
    
    
    public static Stage EDITAR_USUARIO = new Stage();
    
    private Connection connection;
    
    
    
    
    @FXML
	public void cancelar(ActionEvent event) {
		TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO. close();

	}
    
    
    @FXML
	public void excluirUsuario(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaConfirmacaoExcluirConta.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirContaController.STAGE_EXCLUIR_USUARIO.setScene(cena);
			TelaConfirmacaoExcluirContaController.STAGE_EXCLUIR_USUARIO.setTitle("");
			TelaConfirmacaoExcluirContaController.STAGE_EXCLUIR_USUARIO.setResizable(false);
			TelaConfirmacaoExcluirContaController.STAGE_EXCLUIR_USUARIO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    @FXML
	public void editar(ActionEvent event) {
    	Usuario usuario = new Usuario();
    	usuario.setIdUsuario(Usuario.getUsuario().getIdUsuario());
    	usuario.setNome(campoNome.getText());
    	usuario.setLogin(campoLogin.getText());
    	usuario.setSenha(campoSenha.getText());
    	usuario.setEmail(campoEmail.getText());
    	UsuarioBO usu = new UsuarioBO();
    	try {
			usu.verificacaoDosCampos(usuario);
			UsuarioDAO usuDAO = new UsuarioDAO(connection);
			usuDAO.atualizar(usuario);
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setTitle("Mensagem");
			dialogoInfo.setHeaderText("USUARIO EDITADO");
			dialogoInfo.showAndWait();
			MenuPrincipalController.STAGE_MENU_PRINCIPAL.close();
			TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO.close();
			Parent parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaLogin.fxml"));
			Scene cena = new Scene(parent);
			TelaLoginController.STAGE_LOGIN.setScene(cena);
			TelaLoginController.STAGE_LOGIN.setTitle("");
			TelaLoginController.STAGE_LOGIN.setResizable(false);
			TelaLoginController.STAGE_LOGIN.show();
			
		} catch (CampoNaoPreenchidoException | PersistenciaException | IOException | EmailInvalidoException e) {
			Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
			dialogoInfo.setHeaderText(e.getMessage());
			dialogoInfo.showAndWait();
		}
    	

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoNome.setText(Usuario.getUsuario().getNome());
		campoEmail.setText(Usuario.getUsuario().getEmail());
		campoLogin.setText(Usuario.getUsuario().getLogin());
		campoSenha.setText(Usuario.getUsuario().getSenha());
		
	}

    
    
    
    
    
    
    
}
