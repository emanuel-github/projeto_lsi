package projeto.lsi.Exception;

public class ClientesNaoCadastradosException extends Exception {
	
	public ClientesNaoCadastradosException(){
		super("N�o h� clientes cadastrados no sistema");
	}

}
