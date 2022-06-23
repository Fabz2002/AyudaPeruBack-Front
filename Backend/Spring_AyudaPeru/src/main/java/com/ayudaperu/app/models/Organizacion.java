package com.ayudaperu.app.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizaciones")
public class Organizacion {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idorganizacion ;

	private String nombre;

	public long getIdorganizacion() {
		return idorganizacion;
	}

	public void setIdorganizacion(long idorganizacion) {
		this.idorganizacion = idorganizacion;
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
	
	public Organizacion () {
		
	}

	public Organizacion(long idorganizacion, String nombre) {
		super();
		this.idorganizacion = idorganizacion;
		this.nombre = nombre;
	}
	
}

