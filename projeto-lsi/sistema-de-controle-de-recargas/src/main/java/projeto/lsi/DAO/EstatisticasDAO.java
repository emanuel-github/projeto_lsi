package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.mapping.Array;

import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.ClientesNaoCadastradosException;
import projeto.lsi.Exception.NaoExisteRecargaNoIntervaloException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;
import projeto.lsi.pojo.Recarga;

public class EstatisticasDAO {
	
private Connection connection;
	

	public EstatisticasDAO(Connection connection) {
		this.connection = connection;
	}
    
    
    
    
	
	public  List<Recarga> exibeRecargasToner(LocalDate dataInicial, LocalDate dataFinal) throws NaoExisteRecargaNoIntervaloException, PersistenciaException{
		List<Recarga> recargas = new ArrayList<>();
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select modelo, preco, pesoatual, pesofinal from tb_recargatoner where data between ? and ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, java.sql.Date.valueOf( dataInicial ));
			stmt.setDate(2, java.sql.Date.valueOf( dataFinal ));
			ResultSet result = stmt.executeQuery();
			while(result.next()){				
				Recarga recarga = new Recarga();
				recarga.setModelo(result.getString("modelo"));
				recarga.setPreco(result.getDouble("preco"));
				recarga.setPesoInicial(result.getDouble("pesoatual"));
				recarga.setPesoFinal(result.getDouble("pesofinal"));
				recargas.add(recarga);
			}
			if(recargas.isEmpty()){
				throw new NaoExisteRecargaNoIntervaloException();
			}
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}
		return recargas;
	}
	
	
	
	
	
	
	public List<Recarga> exibeRecargasCartucho(LocalDate dataInicial, LocalDate dataFinal) throws NaoExisteRecargaNoIntervaloException, PersistenciaException{
			List<Recarga> recargas = new ArrayList<>();
			Connection connection;	
			try {
				connection = ConexaoFactory.getInstance().getConnection();
				String sql = "select modelo, preco, pesoatual, pesofinal from tb_recargacartucho where data between ? and ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setDate(1, java.sql.Date.valueOf( dataInicial ));
				stmt.setDate(2, java.sql.Date.valueOf( dataFinal ));
				ResultSet result = stmt.executeQuery();
				while(result.next()){				
					Recarga recarga = new Recarga();
					recarga.setModelo(result.getString("modelo"));
					recarga.setPreco(result.getDouble("preco"));
					recarga.setPesoInicial(result.getDouble("pesoatual"));
					recarga.setPesoFinal(result.getDouble("pesofinal"));
					recargas.add(recarga);
				}
				
				connection.close();
				stmt.close();
			} catch (PersistenciaException | SQLException e) {
				throw new PersistenciaException();
			}
			return recargas;
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
		
		
	
	
	
	public  List<Double> lucroTotalRecargasCartucho(LocalDate dataInicial, LocalDate dataFinal) throws PersistenciaException{
		List<Double> listaValores = new ArrayList<>();
		Double soma = 0.0;
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select preco from tb_recargacartucho where data between ? and ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, java.sql.Date.valueOf( dataInicial ));
			stmt.setDate(2, java.sql.Date.valueOf( dataFinal ));
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				listaValores.add(result.getDouble("preco"));
				soma = soma + result.getDouble("preco");				
			}
			
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}
		return listaValores;
	}
	
	
	
	public List<Double> lucroTotalRecargasToner(LocalDate dataInicial, LocalDate dataFinal) throws PersistenciaException{
		List<Double> listaValores = new ArrayList<>();
		Double soma = 0.0;
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select preco from tb_recargatoner where data between ? and ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDate(1, java.sql.Date.valueOf( dataInicial ));
			stmt.setDate(2, java.sql.Date.valueOf( dataFinal ));
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				listaValores.add(result.getDouble("preco"));
				soma = soma + result.getDouble("preco");				
			}
			
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			throw new PersistenciaException();
		}
		return listaValores;
	}

}
