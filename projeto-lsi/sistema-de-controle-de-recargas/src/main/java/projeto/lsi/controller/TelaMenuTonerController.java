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
import javafx.stage.Stage;

public class TelaMenuTonerController implements Initializable {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoPesquisar;
	
    public static Stage STAGE_MENU_TONER = new Stage();
    
    
    @FXML
	public void cadastrarToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaCadastrarToner.fxml"));
			Scene cena = new Scene(parent);
			TelaCadastrarTonerController.STAGE_CADASTRAR_TONER.setScene(cena);
			TelaCadastrarTonerController.STAGE_CADASTRAR_TONER.setTitle("");
			TelaCadastrarTonerController.STAGE_CADASTRAR_TONER.setResizable(false);
			TelaCadastrarTonerController.STAGE_CADASTRAR_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    
    @FXML
	public void pesquisarToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaPesquisarToner.fxml"));
			Scene cena = new Scene(parent);
			TelaPesquisarTonerController.STAGE_PESQUISA_TONER.setScene(cena);
			TelaPesquisarTonerController.STAGE_PESQUISA_TONER.setTitle("");
			TelaPesquisarTonerController.STAGE_PESQUISA_TONER.setResizable(false);
			TelaPesquisarTonerController.STAGE_PESQUISA_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    @FXML
	public void cancelar(ActionEvent event) {
    	STAGE_MENU_TONER.close();
    }
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {

		
	}

}
