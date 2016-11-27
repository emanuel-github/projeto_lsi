package projeto.lsi.logica;

import projeto.lsi.Exception.CampoNaoPreenchidoException;
import projeto.lsi.Exception.EmailInvalidoException;
import projeto.lsi.pojo.Usuario;

public class UsuarioBO {
	
	
	public void verificacaoDosCampos(Usuario usuario) throws CampoNaoPreenchidoException, EmailInvalidoException {
		try {
			if(usuario.getLogin() == null || usuario.getLogin().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo Login n�o Preenchido");
			}else if(usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo senha n�o preenchido");
			}else if(usuario.getNome() == null || usuario.getNome().trim().isEmpty()){
				throw new CampoNaoPreenchidoException("Campo nome � obrigat�rio");
			}else if(!ValidaEmail.isEmailValid(usuario.getEmail())){
				throw new EmailInvalidoException();
			}
		} catch (CampoNaoPreenchidoException e) {
			throw new CampoNaoPreenchidoException(e.getMessage());
		}

	}

}
