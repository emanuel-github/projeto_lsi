package projeto.lsi.Exception;

public class PersistenciaException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PersistenciaException() {
		super("Erro de Persitencia");
	}
	
	
	public PersistenciaException(String msg){
		super(msg);
		
	}
	
	

}
