package projeto.lsi.Exception;

public class LoginOuSenhaIvalidoException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginOuSenhaIvalidoException(){
		super("Login ou senha inválidos ou usuário não cadastrado");
	}
}
