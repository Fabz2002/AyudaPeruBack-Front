package com.ayudaperu.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalledonaciones")
public class DetalleDonacion {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne private Tipodnm tipodnm;
	@OneToOne private Donacion donacion;
	
	@Column(name = "monto", length = 60, nullable = true)
	private double monto;

	@Column(name = "numtarjeta", length = 60, nullable = true)
	private String numtarjeta;

	@Column(name = "mesexpira", length = 60, nullable = true)
	private String mesexpira;
	
	@Column(name = "anioexpira", length = 60, nullable = true)
	private String anioexpira;

	@Column(name = "nomtarjeta", length = 60, nullable = true)
	private String nomtarjeta;

	
	@Column(name = "descripcion", length = 60, nullable = true)
	private String descripcion;

	@Column(name = "cantidad", length = 60, nullable = true)
	private int cantidad;

	@Column(name = "valorunitario", length = 60, nullable = true)
	private double valorunitario;
	
	@Column(name = "total", length = 60, nullable = true)
	private double total;

	public DetalleDonacion() {
		
	}
	
	public DetalleDonacion(double monto, String numtarjeta, String mesexpira, String anioexpira,
		String nomtarjeta, Tipodnm tipodnm, Donacion donacion, String descripcion, int cantidad,
		double valorunitario, double total) {
		
		this.monto = monto;
		this.numtarjeta = numtarjeta;
		this.mesexpira = mesexpira;
		this.anioexpira = anioexpira;
		this.nomtarjeta = nomtarjeta;
		this.tipodnm = tipodnm;
		this.donacion=donacion;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.valorunitario = valorunitario;
		this.total = total;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getNumtarjeta() {
		return numtarjeta;
	}

	public void setNumtarjeta(String numtarjeta) {
		this.numtarjeta = numtarjeta;
	}

	public String getMesexpira() {
		return mesexpira;
	}

	public void setMesexpira(String mesexpira) {
		this.mesexpira = mesexpira;
	}

	public String getAnioexpira() {
		return anioexpira;
	}

	public void setAnioexpira(String anioexpira) {
		this.anioexpira = anioexpira;
	}

	public String getNomtarjeta() {
		return nomtarjeta;
	}

	public void setNomtarjeta(String nomtarjeta) {
		this.nomtarjeta = nomtarjeta;
	}

	public Tipodnm getTipodnm() {
		return tipodnm;
	}

	public void setTipodnm(Tipodnm tipodnm) {
		this.tipodnm = tipodnm;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorunitario() {
		return valorunitario;
	}

	public void setValorunitario(double valorunitario) {
		this.valorunitario = valorunitario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	

	
}
