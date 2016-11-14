package projeto.lsi.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class TelaEstatisticasTonerController {
	
	
    @FXML
    private Button botaoCancelar;

    @FXML
    private DatePicker dataInicial;

    @FXML
    private DatePicker dataFinal;
    
    
    
public static Stage STAGE_ESTATISTICAS_TONER = new Stage();

	
    @FXML
    public void cancelar(ActionEvent event){
    	STAGE_ESTATISTICAS_TONER.close();
    	
    }

}
