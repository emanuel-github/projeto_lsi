package projeto.lsi.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Cliente;
import projeto.lsi.pojo.Usuario;

public class ClienteDAO implements GenericoDAO<Cliente>{
	
	private Connection connection;
	

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}


	public void cadastrar(Cliente cliente) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "insert into tb_cliente (nome,cpf,email,telefone) values (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.execute();
			stmt.close();
			connection.close();	
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
	}
	
	
	
	public List<Cliente> buscarCliente(String nome) throws ClienteNaoEncontradoException, PersistenciaException{
		List<Cliente> clientes = new ArrayList<>();
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select idCliente, nome, cpf, email, telefone from tb_cliente where nome like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome + "%");
			ResultSet result = stmt.executeQuery();

			while(result.next()){				
				Cliente cliente = new Cliente();
				cliente.setIdCliente(result.getInt("idCliente"));
				cliente.setNome(result.getString("nome"));
				cliente.setCpf(result.getString("cpf"));
				cliente.setEmail(result.getString("email"));
				cliente.setTelefone(result.getString("telefone"));
				clientes.add(cliente);
			}
			if(clientes.isEmpty()){
				throw new ClienteNaoEncontradoException();
			}
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		return clientes;
	}
	
	
	
	public void deletar(Integer id) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			PreparedStatement stmt =  connection.prepareStatement("delete from tb_cliente where idCliente = ?");
			stmt.setInt(1,id);
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			//Alert dialogoInfo = new Alert(Alert.AlertType.INFORMATION);
	        //dialogoInfo.setTitle("Mensagem");
	        //dialogoInfo.setHeaderText("Usuário Excluído");
	        //dialogoInfo.showAndWait();
	        
			
		} catch (SQLException | PersistenciaException e) {
			throw new PersistenciaException();
		}
		
	}
		
	
		public void atualizar(Cliente cliente) throws PersistenciaException {
			try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = " UPDATE tb_cliente SET nome = ?, cpf = ?, email = ?, telefone = ? WHERE idcliente = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getIdCliente());	
			stmt.executeUpdate();
			stmt.close();
			connection.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
				//throw new PersistenciaException();
			}

			
		}

		
	


	public void buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void listar() {
		// TODO Auto-generated method stub
		
	}

}
