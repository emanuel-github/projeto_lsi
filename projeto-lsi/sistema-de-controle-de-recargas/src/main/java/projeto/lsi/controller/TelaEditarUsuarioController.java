package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
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

    
    
    
    
    @FXML
	public void cancelar(ActionEvent event) {
		TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO. close();

	}
    
    
    @FXML
	public void excluirUsuario(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaConfirmacaoExcluirConta.fxml"));
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
		Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
        dialogoInfo.setTitle("Mensagem");
        dialogoInfo.setHeaderText("USUARIO EDITADO");
        dialogoInfo.showAndWait();

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		campoNome.setText(Usuario.getUsuario().getNome());
		campoEmail.setText(Usuario.getUsuario().getEmail());
		campoLogin.setText(Usuario.getUsuario().getLogin());
		campoSenha.setText(Usuario.getUsuario().getSenha());
		
	}

    
    
    
    
    
    
    
}
