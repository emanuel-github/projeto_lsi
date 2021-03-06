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

public class TelaMenuCartuchoController implements Initializable{

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoPesquisar;
    
    
    public static Stage STAGE_MENU_CARTUCHO = new Stage();
    
    
    
    @FXML
	public void cadastrarCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaCadastrarCartucho.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_CARTUCHO.setScene(cena);
			STAGE_MENU_CARTUCHO.setTitle("");
			STAGE_MENU_CARTUCHO.setResizable(false);
			STAGE_MENU_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    @FXML
	public void pesquisarCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("/projeto/lsi/gui/TelaPesquisarCartucho.fxml"));
			Scene cena = new Scene(parent);
			STAGE_MENU_CARTUCHO.setScene(cena);
			STAGE_MENU_CARTUCHO.setTitle("");
			STAGE_MENU_CARTUCHO.setResizable(false);
			STAGE_MENU_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
    
    
    @FXML
    public void cancelar(ActionEvent envent){
    	STAGE_MENU_CARTUCHO.close();
    }
			

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
