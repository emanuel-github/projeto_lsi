package projeto.lsi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuPrincipalController implements Initializable{

	
	    @FXML
	    private MenuBar menuBarMenuPrincipal;

	    @FXML
	    private MenuItem menuItemSairContaUsuario;

	    @FXML
	    private MenuItem menuItemCartuchoServicos;

	    @FXML
	    private ImageView imagemMenuPrincipal;

	    @FXML
	    private MenuItem menuItemCadastrarCliente;

	    @FXML
	    private MenuItem menuItemLucroTotalRelatorios;

	    @FXML
	    private Menu menuServicos;

	    @FXML
	    private MenuItem menuItemTonerServicos;

	    @FXML
	    private Menu menuCliente;

	    @FXML
	    private MenuItem menuItemRecCartRelatorios;

	    @FXML
	    private MenuItem menuItemRecTonerRelatorios;

	    @FXML
	    private Menu menuUsuario;

	    @FXML
	    private MenuItem MenuItemConfContaUsuario;

	    @FXML
	    private MenuItem menuItemRecargaServicos;

	    @FXML
	    private MenuItem menuiItemPesquisarCliente;

	    @FXML
	    private Menu menuRelatorios;

	    @FXML
	    private MenuItem menuItemListaClientesRelatorios;

	    private Stage stage = new Stage();
	    public static Stage STAGE_MENU_PRINCIPAL = new Stage();
	    
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		
		
		
	}
	
	

	
	@FXML
	void chamaTelaDeConfiguracaoUsuario(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaLoginParaAtualizacao.fxml"));
			Scene cena = new Scene(parent);
			TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO.setScene(cena);
			TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO.setTitle("");
			TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO.setResizable(false);
			TelaLoginParaAtualizacaoController.STAGE_TELA_LOGIN_ATUALIZACAO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void sair(ActionEvent event) {
		System.exit(0);
		
	}
	
				
	
	
		
	
	@FXML
	public void chamaTelaCadastrarCliente(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaCadastroDeClientes.fxml"));
			Scene cena = new Scene(parent);
			TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.setScene(cena);
			TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.setTitle("");
			TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.setResizable(false);
			TelaCadastroDeClientesController.STAGE_CADASTRO_CLIENTE.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
			
	@FXML
	public void chamaTelaPesquisarCliente(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaPesquisarCliente.fxml"));
			Scene cena = new Scene(parent);
			TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.setScene(cena);
			TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.setTitle("");
			TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.setResizable(false);
			TelaPesquisaClienteController.STAGE_PESQUISA_CLIENTE.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void chamaTelaMenuCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaMenuCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.setScene(cena);
			TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.setTitle("");
			TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.setResizable(false);
			TelaMenuCartuchoController.STAGE_MENU_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
	public void chamaTelaMenuToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaMenuToner.fxml"));
			Scene cena = new Scene(parent);
			TelaMenuTonerController.STAGE_MENU_TONER.setScene(cena);
			TelaMenuTonerController.STAGE_MENU_TONER.setTitle("");
			TelaMenuTonerController.STAGE_MENU_TONER.setResizable(false);
			TelaMenuTonerController.STAGE_MENU_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void chamaTelaMenuRecarga(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaMenuRecarga.fxml"));
			Scene cena = new Scene(parent);
			TelaMenuRecargaController.STAGE_MENU_RECARGA.setScene(cena);
			TelaMenuRecargaController.STAGE_MENU_RECARGA.setTitle("");
			TelaMenuRecargaController.STAGE_MENU_RECARGA.setResizable(false);
			TelaMenuRecargaController.STAGE_MENU_RECARGA.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void chamaTelaEstatisticasCartucho(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaEstatisticasCartucho.fxml"));
			Scene cena = new Scene(parent);
			TelaEstatisticasCartuchoController.STAGE_ESTATISTICAS_CARTUCHO.setScene(cena);
			TelaEstatisticasCartuchoController.STAGE_ESTATISTICAS_CARTUCHO.setTitle("");
			TelaEstatisticasCartuchoController.STAGE_ESTATISTICAS_CARTUCHO.setResizable(false);
			TelaEstatisticasCartuchoController.STAGE_ESTATISTICAS_CARTUCHO.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@FXML
	public void chamaTelaEstatisticasToner(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaEstatisticasToner.fxml"));
			Scene cena = new Scene(parent);
			TelaEstatisticasTonerController.STAGE_ESTATISTICAS_TONER.setScene(cena);
			TelaEstatisticasTonerController.STAGE_ESTATISTICAS_TONER.setTitle("");
			TelaEstatisticasTonerController.STAGE_ESTATISTICAS_TONER.setResizable(false);
			TelaEstatisticasTonerController.STAGE_ESTATISTICAS_TONER.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	@FXML
	public void chamaTelaLucroEmRecargas(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaLucroEmRecargas.fxml"));
			Scene cena = new Scene(parent);
			TelaLucroEmRecargasController.STAGE_LUCRO_RECARGAS.setScene(cena);
			TelaLucroEmRecargasController.STAGE_LUCRO_RECARGAS.setTitle("");
			TelaLucroEmRecargasController.STAGE_LUCRO_RECARGAS.setResizable(false);
			TelaLucroEmRecargasController.STAGE_LUCRO_RECARGAS.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	@FXML
	public void chamaTelaListaDeClientes(ActionEvent event) {
		Parent parent;
		try {			
			parent = FXMLLoader.load(getClass().getResource("../gui/TelaListaDeClientes.fxml"));
			Scene cena = new Scene(parent);
			stage.setScene(cena);
			stage.setTitle("");
			stage.setResizable(false);
			stage.show();						
		} catch (IOException e) {
			e.printStackTrace();
		}

	}




	
	

}
