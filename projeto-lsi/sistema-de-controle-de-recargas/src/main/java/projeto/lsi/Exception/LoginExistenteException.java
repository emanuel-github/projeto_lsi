package projeto.lsi.Exception;

public class LoginExistenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginExistenteException(){
		super("Login Existente");
	}

}
