package projeto.lsi.DAO;

import java.sql.SQLException;

import projeto.lsi.Exception.PersistenciaException;

public interface GenericoDAO<T> {
	
	void cadastrar (T obj) throws PersistenciaException;
	
	void atualizar (T obj);
	
	void deletar (Integer id);
	
	void buscarPorId(Integer id) throws PersistenciaException;
	
	void listar();
	
	
	

}
