package projeto.lsi.Exception;

public class ClientesNaoCadastradosException extends Exception {
	
	public ClientesNaoCadastradosException(){
		super("Não há clientes cadastrados no sistema");
	}

}
