package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.lsi.Exception.CartuchoNaoEncontradoException;
import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.Exception.TonerNaoEncontradoException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Cartucho;
import projeto.lsi.pojo.Toner;

public class TonerDao implements GenericoDAO<Toner>{
	
	
private Connection connection;
	
	public TonerDao(Connection connection) {
		this.connection = connection;
	}


	public void cadastrar(Toner toner) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "insert into tb_toner (modelo,preco) values (?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, toner.getModelo());
			stmt.setDouble(2, toner.getPreco());
			stmt.execute();
			stmt.close();
			connection.close();	
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		
		
	}
	
	
	
	public List<Toner> buscarToner(String nome) throws PersistenciaException, TonerNaoEncontradoException{
		List<Toner> toners = new ArrayList<>();
		Connection connection;	
		try {
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "select idToner, modelo, preco from tb_toner where modelo like ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nome + "%");
			ResultSet result = stmt.executeQuery();
			while(result.next()){				
				Toner toner = new Toner();
				toner.setIdToner(result.getInt("idToner"));
				toner.setModelo(result.getString("modelo"));
				toner.setPreco(result.getDouble("preco"));
				toners.add(toner);
			}
			if(toners.isEmpty()){
				throw new TonerNaoEncontradoException();
			}
			connection.close();
			stmt.close();
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		return toners;
	}
	
	
	
	public void deletar(Integer id) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			PreparedStatement stmt =  connection.prepareStatement("delete from tb_toner where idToner = ?");
			stmt.setInt(1,id);
			stmt.executeUpdate();
			stmt.close();
			connection.close();			
		} catch (SQLException | PersistenciaException e) {
			throw new PersistenciaException();
		}		
		
	}

	public void atualizar(Toner toner) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = " UPDATE tb_toner SET modelo = ?, preco = ? WHERE idToner = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, toner.getModelo());
			stmt.setDouble(2, toner.getPreco());
			stmt.setInt(3, toner.getIdToner());
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
