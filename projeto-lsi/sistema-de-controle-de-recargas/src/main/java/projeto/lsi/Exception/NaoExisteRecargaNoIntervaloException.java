package projeto.lsi.Exception;



public class NaoExisteRecargaNoIntervaloException extends Exception {
	
	public NaoExisteRecargaNoIntervaloException(){
		super("N�o existem recargas nesse intervalo");
	}

}
