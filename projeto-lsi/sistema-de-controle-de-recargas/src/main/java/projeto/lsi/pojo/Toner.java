package projeto.lsi.pojo;

public class Toner {
	
	private Integer idToner;
	private String modelo;
	private Double preco;
	public static Toner toner;
	
	
	public static Toner getToner() {
		return toner;
	}
	public static void setToner(Toner toner) {
		Toner.toner = toner;
	}
	public Integer getIdToner() {
		return idToner;
	}
	public void setIdToner(Integer idToner) {
		this.idToner = idToner;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return idToner + ", modelo=" + modelo + ", preco=" + preco;
	}
	

}
