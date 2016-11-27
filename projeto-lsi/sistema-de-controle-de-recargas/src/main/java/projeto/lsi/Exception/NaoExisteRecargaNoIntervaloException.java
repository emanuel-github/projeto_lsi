package projeto.lsi.Exception;



public class NaoExisteRecargaNoIntervaloException extends Exception {
	
	public NaoExisteRecargaNoIntervaloException(){
		super("Não existem recargas nesse intervalo");
	}

}
