package projeto.lsi.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import projeto.lsi.Exception.PersistenciaException;
import projeto.lsi.conexao.ConexaoFactory;
import projeto.lsi.pojo.Recarga;

public class RecargaDAO implements GenericoDAO<Recarga> {
	
	private Connection connection;
	
	public RecargaDAO(Connection connection) {
		this.connection = connection;
	}
	
	

	public void cadastrarRecargaCartucho(Recarga recarga) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "insert into tb_recargacartucho (modelo,data,preco,pesoatual,pesofinal) values (?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, recarga.getModelo());
			java.sql.Date dataParaGravar = new java.sql.Date(
			        Calendar.getInstance().getTimeInMillis());
			stmt.setDate(2, dataParaGravar);			
			stmt.setDouble(3, recarga.getPreco());
			stmt.setDouble(4, recarga.getPesoInicial());
			stmt.setDouble(5, recarga.getPesoFinal());
			stmt.execute();
			stmt.close();
			connection.close();	
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		
	}
	
	
	
	public void cadastrarRecargaToner(Recarga recarga) throws PersistenciaException {
		try {
			Connection connection;
			connection = ConexaoFactory.getInstance().getConnection();
			String sql = "insert into tb_recargatoner (modelo,data,preco,pesoatual,pesofinal) values (?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, recarga.getModelo());
			java.sql.Date dataParaGravar = new java.sql.Date(
			        Calendar.getInstance().getTimeInMillis());
			stmt.setDate(2, dataParaGravar);			
			stmt.setDouble(3, recarga.getPreco());
			stmt.setDouble(4, recarga.getPesoInicial());
			stmt.setDouble(5, recarga.getPesoFinal());
			stmt.execute();
			stmt.close();
			connection.close();	
		} catch (PersistenciaException | SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		
	}

	public void atualizar(Recarga obj) {
		// TODO Auto-generated method stub
		
	}

	public void deletar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar(Recarga obj) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

}
