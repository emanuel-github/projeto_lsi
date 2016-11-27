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
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaCadastrarToner.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_TONER.setScene(cena);
			STAGE_MENU_TONER.setTitle("");
			STAGE_MENU_TONER.setResizable(false);
			STAGE_MENU_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    
    
    @FXML
	public void pesquisarToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaPesquisarToner.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_TONER.setScene(cena);
			STAGE_MENU_TONER.setTitle("");
			STAGE_MENU_TONER.setResizable(false);
			STAGE_MENU_TONER.show();						
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
