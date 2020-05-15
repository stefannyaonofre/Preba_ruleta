package pruebaRuleta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ruleta {
	@Id
	private int idRuleta;
		
	@Column(name="estado")
	private String estado ;

	public int getIdRuleta() {
		return idRuleta;
	}

	public void setIdRuleta(int idRuleta) {
		this.idRuleta = idRuleta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	

	}

