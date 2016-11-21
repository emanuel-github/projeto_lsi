package projeto.lsi.DAO;





import projeto.lsi.Exception.PersistenciaException;

public interface GenericoDAO<T> {
	
	void cadastrar (T obj) throws PersistenciaException;
	
	void atualizar (T obj) throws PersistenciaException;
	
	void deletar (Integer id) throws PersistenciaException;
	
	void buscarPorId(Integer id) throws PersistenciaException;
	
	void listar();
	
	
	

}
