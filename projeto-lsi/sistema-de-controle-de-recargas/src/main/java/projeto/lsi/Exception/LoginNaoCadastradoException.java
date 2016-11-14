package projeto.lsi.Exception;

public class LoginNaoCadastradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginNaoCadastradoException(){
		super("Login ou senha inválidos");
	}

}
