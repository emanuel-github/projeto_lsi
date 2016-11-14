package projeto.lsi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class TelaLucroEmRecargasController implements Initializable {

    @FXML
    private Button botaoCancelar;

    @FXML
    private Button botaoConsultar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;

    public static Stage STAGE_LUCRO_RECARGAS = new Stage();

	
    @FXML
    public void cancelar(ActionEvent event){
    	STAGE_LUCRO_RECARGAS.close();
    	
    }

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
