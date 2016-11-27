package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import projeto.lsi.Exception.LoginExistenteException;

import projeto.lsi.Exception.LoginOuSenhaIvalidoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Usuario;

public class UsuarioDAO implements GenericoDAO<Usuario>{

	private Connection connection;





	public UsuarioDAO(Connection connection) {
		this.connection = connection;
	}




	public boolean logar(String login, String senha) throws LoginOuSenhaIvalidoException, PersistenciaException{
		try {
			Connection connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select login, senha from tb_usuario where login = ? and senha = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, senha);
			ResultSet result = stmt.executeQuery();
			if(result.next()){
				connection.close();
				stmt.close();
				return true;
			}else{
				throw new LoginOuSenhaIvalidoException();
			}

		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}			
	}







	public void cadastrar(Usuario usuario) throws PersistenciaException{
		try {
			if(naoContemLogin(usuario.getLogin())){
				Connection connection = ConexaoFactory.getInstance().getConnection();
				String sql = "insert into tb_usuario (nome,email,login,senha) values (?,?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setString(3, usuario.getLogin());
				stmt.setString(4, usuario.getSenha());
				stmt.execute();
				stmt.close();
				connection.close();	

			}else{
				throw new LoginExistenteException();
			}

		} catch (LoginExistenteException e) {
			throw new PersistenciaException(e.getMessage());
		}catch(SQLException e1){
			throw new PersistenciaException();
		}
	}








	private boolean naoContemLogin(String login) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select login from tb_usuario where login = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, login);
			ResultSet result = stmt.executeQuery();
			if(!result.next()){
				connection.close();
				stmt.close();
				return true;
			}else{
				throw new LoginExistenteException();
			}

		} catch (PersistenciaException | LoginExistenteException | SQLException e) {
			throw new PersistenciaException(e.getMessage());
		}
	}









	public void logarParaAtualizar(String login, String senha) throws LoginOuSenhaIvalidoException, PersistenciaException{
		try {
			if(logar(login, senha)){				
				Connection connection = ConexaoFactory.getInstance().getConnection();
				String sql = "select idusuario, nome, email, login, senha from tb_usuario where login = ? and senha = ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, login);
				stmt.setString(2, senha);
				ResultSet result = stmt.executeQuery();
				if(result.next()){
					Usuario.getUsuario().setNome(result.getString("nome"));
					Usuario.getUsuario().setEmail(result.getString("email"));
					Usuario.getUsuario().setLogin(result.getString("login"));
					Usuario.getUsuario().setSenha(result.getString("senha"));
					Usuario.getUsuario().setIdUsuario(result.getInt("idusuario"));
					connection.close();
					stmt.close();

				}
			}

		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}			

	}



	public void atualizar(Usuario usuario) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = " UPDATE tb_usuario SET nome = ?, email = ?, login = ?, senha = ? WHERE idusuario = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getLogin());
			stmt.setString(4, usuario.getSenha());
			stmt.setInt(5, usuario.getIdUsuario());	
			stmt.executeUpdate();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new PersistenciaException();
		}


	}






	public void deletar(Integer id) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			PreparedStatement stmt =  connection.prepareStatement("delete from tb_usuario where idUsuario = ?");
			stmt.setInt(1, Usuario.getUsuario().getIdUsuario());
			stmt.executeUpdate();
			stmt.close();
			connection.close();
		} catch (SQLException | PersistenciaException e) {
			throw new PersistenciaException();
		}

	}

	public void buscarPorId(Integer id) throws PersistenciaException{
		Usuario usuario;		
		try {
			PreparedStatement stmt =  connection.prepareStatement("select nome, email, login from TB_USUARIO where idUsuario = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				usuario = new Usuario();
				usuario.setIdUsuario(id);
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				System.out.println(usuario);
				connection.close();
				stmt.close();
				rs.close();
			}else{
				throw new PersistenciaException();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}


	}




	public void listar() {
		// TODO Auto-generated method stub

	}







	/*
	 * 
	private int insereLogin(Usuario usuario) throws PersistenciaException, LoginExistenteException{
		int chave = 0;
		try {
			Connection connection = ConexaoFactory.getInstance().getConnection();
			if(contemLogin(usuario)){
				throw new LoginExistenteException();
			}else{
				PreparedStatement stmt;
				stmt = connection.prepareStatement("insert into tb_login(login,senha)values(?,?)", Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, usuario.getLogin());
				stmt.setString(2, usuario.getSenha());
				stmt.execute();
				ResultSet result = stmt.getGeneratedKeys();
				if(result.next()){
					chave = result.getInt(1);
					stmt.close();
					connection.close();
				}
			}
		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}
		return chave;	
	}
	 */
}
