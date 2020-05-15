package pruebaRuleta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Apuesta { 
	
	@Id
	private int idApuesta;
	
	@Column(name="numeroApuesta")
	private int numeroApuesta;
	
	@Column(name="color")
	private String color;
	
	@Column(name="valorApuesta")
	private double valorApuesta;
	
	@Column(name="idUsuario")
	private int idUsuario;

	public int getIdApuesta() {
		return idApuesta;
	}

	public void setIdApuesta(int idApuesta) {
		this.idApuesta = idApuesta;
	}

	public int getNumeroApuesta() {
		return numeroApuesta;
	}

	public void setNumeroApuesta(int numeroApuesta) {
		this.numeroApuesta = numeroApuesta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getValorApuesta() {
		return valorApuesta;
	}

	public void setValorApuesta(double valorApuesta) {
		this.valorApuesta = valorApuesta;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	
}