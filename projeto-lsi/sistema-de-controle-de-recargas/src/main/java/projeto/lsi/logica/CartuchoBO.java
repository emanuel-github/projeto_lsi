package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;

public class CartuchoBO {
	
	
	public void verificacaoDosCampos(Cartucho cartucho) throws CampoNaoPreenchidoException {
		try {
			if(cartucho.getModelo() == null || cartucho.getModelo().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Modelo do cartucho não preenchido");
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}

}
