package projeto.lsi.pojo;

public class Cartucho {

	private Integer idCartucho;
	private String modelo;
	private Double preco;
	public static Cartucho cartucho;
	
	
	
	public static Cartucho getCartucho() {
		return cartucho;
	}
	public static void setCartucho(Cartucho cartucho) {
		Cartucho.cartucho = cartucho;
	}
	public Integer getIdCartucho() {
		return idCartucho;
	}
	public void setIdCartucho(Integer idCartucho) {
		this.idCartucho = idCartucho;
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
		return idCartucho + ", modelo=" + modelo + ", preco=" + preco;
	}
	
	
	
	
	
}
