package projeto.lsi.main;

import java.sql.Connection;
import java.sql.SQLException;

import projeto.lsi.DAO.UsuarioDAO;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Usuario;

public class Teste {

	public static void main(String[] args) throws PersistenciaException {
		
		//Usuario usuario = new Usuario();
		//usuario.setNome("Edjailson");
		//usuario.setEmail("edjailsonrodrigues@rocketmail.com");
		//usuario.setLogin("edjailson");
		//usuario.setSenha("12345");
		
		Connection con = ConexaoFactory.getInstance().getConnection();
		UsuarioDAO dao = new UsuarioDAO(con);
		//dao.cadastrar(usuario);
		dao.buscarPorId(2);
		
		
		
		
		

	}

}
