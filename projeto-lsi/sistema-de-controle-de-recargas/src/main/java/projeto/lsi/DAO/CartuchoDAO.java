package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.ClienteNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Cliente;

public class CartuchoDAO implements GenericoDAO<Cartucho> {
	
	
	private Connection connection;
	
	public CartuchoDAO(Connection connection) {
		this.connection = connection;
	}

	
	
	public void cadastrar(Cartucho cartucho) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "insert into tb_cartucho (modelo,preco) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cartucho.getModelo());
			stmt.setDouble(2, cartucho.getPreco());
			stmt.execute();
			stmt.close();
			connection.close();	
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		
	}
	
	
	
	
	public List<Cartucho> buscarCartucho(String nome) throws CartuchoNaoEncontradoException, PersistenciaException{
		List<Cartucho> cartuchos = new ArrayList<>();
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select idCartucho, modelo, preco from tb_cartucho where modelo like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome + "%");
			ResultSet result = stmt.executeQuery();
			while(result.next()){				
				Cartucho cartucho = new Cartucho();
				cartucho.setIdCartucho(result.getInt("idCartucho"));
				cartucho.setModelo(result.getString("modelo"));
				cartucho.setPreco(result.getDouble("preco"));
				cartuchos.add(cartucho);
			}
			if(cartuchos.isEmpty()){
				throw new CartuchoNaoEncontradoException();
			}
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		return cartuchos;
	}
	
	
	public List<Cartucho> buscartodosCartuchos() throws CartuchoNaoEncontradoException, PersistenciaException{
		List<Cartucho> cartuchos = new ArrayList<>();
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select * from tb_cartucho";
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			while(result.next()){				
				Cartucho cartucho = new Cartucho();
				cartucho.setIdCartucho(result.getInt("idCartucho"));
				cartucho.setModelo(result.getString("modelo"));
				cartucho.setPreco(result.getDouble("preco"));
				cartuchos.add(cartucho);
			}
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		return cartuchos;
	}
	
	
	
	
	public void deletar(Integer id) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			PreparedStatement stmt =  connection.prepareStatement("delete from tb_cartucho where idCartucho = ?");
			stmt.setInt(1,id);
			stmt.executeUpdate();
			stmt.close();
			connection.close();			
		} catch (SQLException | PersistenciaException e) {
			throw new PersistenciaException();
		}		
	}

	
	
	
	
	@Override
	public void atualizar(Cartucho cartucho) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = " UPDATE tb_cartucho SET modelo = ?, preco = ? WHERE idcartucho = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cartucho.getModelo());
			stmt.setDouble(2, cartucho.getPreco());
			stmt.setInt(3, cartucho.getIdCartucho());
			stmt.executeUpdate();
			stmt.close();
			connection.close();

		} catch (SQLException e) {
			throw new PersistenciaException();
		}
	}
	
	
	

	public void buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void listar() {
		// TODO Auto-generated method stub
		
	}




}
