package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.ClientesNaoCadastradosException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;

public class EstatisticasDAO {
	
private Connection connection;
	

	public EstatisticasDAO(Connection connection) {
		this.connection = connection;
	}
    
    
    
    
	
	public static void exibeRecargasToner(){
		
	}
	
	
	public static void exibeRecargasCartucho(){
		
	}
	
	
	
	public List<Cliente> listarClientes() throws ClientesNaoCadastradosException, PersistenciaException{
		List<Cliente> clientes = new ArrayList<>();
			Connection connection;	
			try {
				connection = ConexaoFactory.getInstance().getConnection();
				String sql = "select * from tb_cliente";
				PreparedStatement stmt = connection.prepareStatement(sql);
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
					throw new ClientesNaoCadastradosException();
				}
				connection.close();
				stmt.close();
			} catch (PersistenciaException | SQLException e) {
				e.printStackTrace();
				throw new PersistenciaException();
			}
			return clientes;
		}
		
		
	
	
	
	public static void lucroTotalRecargas(){
		
	}

}
