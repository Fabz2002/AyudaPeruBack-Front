package com.ayudaperu.app.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiposdnmes")
public class Tipodnm {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idtipodnm;

	private String nombre;



	public long getIdtipodnm() {
		return idtipodnm;
	}

	public void setIdtipodnm(long idtipodnm) {
		this.idtipodnm = idtipodnm;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Tipodnm(long idtipodnm, String nombre) {
		super();
		this.idtipodnm = idtipodnm;
		this.nombre = nombre;
	}

	public Tipodnm() {
		
	}
}
