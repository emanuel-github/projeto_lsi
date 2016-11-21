package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.pojo.Recarga;

public class RecargaBO {
	
	public void verificacaoDosCampos(Recarga recarga) throws CampoNaoPreenchidoException {
		try {
			if(recarga.getModelo() == null || recarga.getModelo().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Modelo não preenchido");
			}else if(recarga.getPreco() == null){
				throw new CampoNaoPreenchidoException("Campo Preço da recarga não preenchido");
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}

}
