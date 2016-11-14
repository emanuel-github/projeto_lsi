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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaPesquisaClienteController implements Initializable{

    @FXML
    private Button botaoExcluir;

    @FXML
    private Button botaoCancelar;

    @FXML
    private ListView<?> listViewResultadosPesquisa;

    @FXML
    private Button botaoConsultar;

    @FXML
    private TextField campoPesquisa;

    @FXML
    private Button botaoEditar;
	
    
    public static Stage STAGE_PESQUISA_CLIENTE = new Stage();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@FXML
	public void pesquisarCliente(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaEditarCliente.fxml"));
			Scene cena = new Scene(parent);
			TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setScene(cena);
			TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setTitle("");
			TelaEditarClienteController.STAGE_EDITAR_CLIENTE.setResizable(false);
			TelaEditarClienteController.STAGE_EDITAR_CLIENTE.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
			
	@FXML
	public void excluirCliente(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaConfirmacaoExcluirCliente.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setScene(cena);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setTitle("");
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.setResizable(false);
			TelaConfirmacaoExcluirClienteController.STAGE_EXCLUIR_CLIENTE.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void cancelar(ActionEvent event) {
		TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.close();						
	}

}
