package projeto.lsi.pojo;

import java.util.Calendar;
import java.util.Date;

public class Recarga {
	
	private Integer idRecarga;
	private String modelo;
	private Calendar data;
	private Double preco;
	private Double pesoInicial;
	private Double pesoFinal;
	private String dataString;
	
	
	
	public Integer getIdRecarga() {
		return idRecarga;
	}
	public void setIdRecarga(Integer idRecarga) {
		this.idRecarga = idRecarga;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getPesoInicial() {
		return pesoInicial;
	}
	public void setPesoInicial(Double pesoInicial) {
		this.pesoInicial = pesoInicial;
	}
	public Double getPesoFinal() {
		return pesoFinal;
	}
	public void setPesoFinal(Double pesoFinal) {
		this.pesoFinal = pesoFinal;
	}
	
	
	
	
	
	
	
	

}
