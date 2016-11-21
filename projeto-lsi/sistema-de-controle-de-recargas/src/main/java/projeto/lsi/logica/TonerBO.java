package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Toner;

public class TonerBO {
	
	
	public void verificacaoDosCampos(Toner toner) throws CampoNaoPreenchidoException {
		try {
			if(toner.getModelo() == null || toner.getModelo().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Modelo do toner não preenchido");
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}

}
