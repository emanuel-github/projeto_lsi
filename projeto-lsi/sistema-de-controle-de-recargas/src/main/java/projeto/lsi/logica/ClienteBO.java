package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.pojo.Cliente;
import projeto.lsi.pojo.Usuario;

public class ClienteBO {
	
	public void verificacaoDosCampos(Cliente cliente) throws CampoNaoPreenchidoException {
		try {
			if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Nome n�o Preenchido");
			}else if(cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Telefone n�o preenchido");
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}
}
