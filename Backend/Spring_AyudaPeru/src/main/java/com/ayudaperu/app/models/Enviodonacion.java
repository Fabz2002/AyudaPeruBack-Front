package com.ayudaperu.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enviodonaciones")
public class Enviodonacion {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne private Tipodnm tipodnm;
	@OneToOne private Organizacion organizacion;
	@OneToOne private Donacion donacion;
	
	@Column(name = "descripcion", length = 60, nullable = false)
	private String descripcion;

	@Column(name = "direccion", length = 60, nullable = false)
	private String direccion;

	@Column(name = "estado")
	private boolean estado;
	
	public Enviodonacion() {
		
	}

	public Enviodonacion(long id, Tipodnm tipodnm, Organizacion organizacion,Donacion donacion, String descripcion, String direccion,
			boolean estado) {
		super();
		this.id = id;
		this.tipodnm = tipodnm;
		this.organizacion = organizacion;
		this.donacion=donacion;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tipodnm getTipodnm() {
		return tipodnm;
	}

	public void setTipodnm(Tipodnm tipodnm) {
		this.tipodnm = tipodnm;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
	

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
