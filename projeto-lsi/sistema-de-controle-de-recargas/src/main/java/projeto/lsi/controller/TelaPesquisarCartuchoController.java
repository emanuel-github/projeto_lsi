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

public class TelaPesquisarCartuchoController implements Initializable {

	
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
    
      
    public static Stage STAGE_PESQUISA_CARTUCHO = new Stage();
    
    
    
    @FXML
	public void editarCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaEditarCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setScene(cena);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setTitle("");
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.setResizable(false);
			TelaEditarCartuchoController.STAGE_EDITAR_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    public void excluirCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaConfirmacaoExcluirCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setScene(cena);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setTitle("");
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.setResizable(false);
			TelaConfirmacaoExcluirCartuchoController.STAGE_CONFIRMACAO_EXCLUIR_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_PESQUISA_CARTUCHO.close();
    }
    
    
    
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
