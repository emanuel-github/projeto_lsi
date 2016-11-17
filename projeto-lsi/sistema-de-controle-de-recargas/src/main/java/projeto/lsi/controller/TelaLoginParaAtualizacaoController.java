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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.LoginOuSenhaIvalidoException;
import projeto.lsi.Exception.PersistenciaException;

public class TelaLoginParaAtualizacaoController implements Initializable{

    @FXML
    private TextField campoLogin;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Label senhaLabel;

    @FXML
    private Label loginLabel;

    @FXML
    private ImageView imagemMenuPrincipal;

    @FXML
    private PasswordField campoSenha;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	Connection connection;

	public static Stage STAGE_TELA_LOGIN_ATUALIZACAO = new Stage();
	
	@FXML
	public void chamaTelaEditarUsuario(ActionEvent event) {
	//	UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
		try {
			//usuarioDAO.logarParaAtualizar(campoLogin.getText(), campoSenha.getText());
			Parent parent;
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaEditarUsuario.fxml"));
			Scene cena = new Scene(parent);
			STAGE_TELA_LOGIN_ATUALIZACAO.setScene(cena);
			STAGE_TELA_LOGIN_ATUALIZACAO.setTitle("");
			STAGE_TELA_LOGIN_ATUALIZACAO.setResizable(false);
			STAGE_TELA_LOGIN_ATUALIZACAO.show();						
	//	} catch (LoginOuSenhaIvalidoException | PersistenciaException e1) {
		//	Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
	     //   dialogoInfo.setTitle("Mensagem");
	     //   dialogoInfo.setHeaderText(e1.getMessage());
	     //   dialogoInfo.showAndWait();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}




	@FXML
	public void cancelar(ActionEvent event) {
		STAGE_TELA_LOGIN_ATUALIZACAO.close();
	}
}
