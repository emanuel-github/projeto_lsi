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

public class TelaPesquisarTonerController implements Initializable{
	
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
	
	
	public static Stage STAGE_PESQUISA_TONER = new Stage();
	
	
	
	@FXML
	public void editarToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaEditarToner.fxml"));
			Scene cena = new Scene(parent);
			TelaEditarTonerController.STAGE_EDITAR_TONER.setScene(cena);
			TelaEditarTonerController.STAGE_EDITAR_TONER.setTitle("");
			TelaEditarTonerController.STAGE_EDITAR_TONER.setResizable(false);
			TelaEditarTonerController.STAGE_EDITAR_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	public void excluirToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaConfirmacaoExcluirToner.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setScene(cena);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setTitle("");
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.setResizable(false);
			TelaConfirmacaoExcluirTonerController.STAGE_CONFIRMACAO_EXCLUIR_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void cancelar(ActionEvent event) {
    	STAGE_PESQUISA_TONER.close();
    }
    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
