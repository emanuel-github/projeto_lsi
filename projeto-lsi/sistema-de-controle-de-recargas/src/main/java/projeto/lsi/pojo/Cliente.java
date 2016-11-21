package projeto.lsi.pojo;

public class Cliente {
	
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	public static Cliente cliente;
	
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public static Cliente getCliente() {
		return cliente;
	}
	public static void setCliente(Cliente cliente) {
		Cliente.cliente = cliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	@Override
	public String toString() {
		return "ID: " + this.getIdCliente() + " | NOME: " + this.getNome() + " | EMAIL: " + this.getEmail() + " | TELEFONE: " + this.getTelefone();
	}
	
	
	
	
	
	
	
	

}
