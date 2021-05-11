package ec.edu.ups.modelo;

import java.io.Serializable;

public class Telefono implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer codigo;
	private String numero;
	private String tipo;
	private String operadora;
	
	public Telefono(Integer codigo, String numero, String tipo, String operadora) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	

}
