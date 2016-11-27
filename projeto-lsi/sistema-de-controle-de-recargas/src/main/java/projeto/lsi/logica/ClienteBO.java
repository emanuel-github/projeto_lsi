package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.CpfInvalidoException;
import projeto.lsi.Exception.EmailInvalidoException;
import projeto.lsi.pojo.Cliente;
import projeto.lsi.pojo.Usuario;

public class ClienteBO {
	
	public void verificacaoDosCampos(Cliente cliente) throws CampoNaoPreenchidoException, CpfInvalidoException, EmailInvalidoException {
		try {
			if(cliente.getNome() == null || cliente.getNome().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Nome não Preenchido");
			}else if(cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Telefone não preenchido");
			}else if(!ValidaCPF.isCPF(cliente.getCpf())){
				throw new CpfInvalidoException();
			}else if(!ValidaEmail.isEmailValid(cliente.getEmail())){
				throw new EmailInvalidoException();
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}
}
