package com.ayudaperu.app.viewmodels;

import javax.persistence.Column;
import javax.persistence.OneToOne;

import com.ayudaperu.app.models.Donacion;
import com.ayudaperu.app.models.Tipodnm;

public class DonacionDetalleViewModel {
	
	private int rowIndex;
	private long id;
	private Tipodnm tipodnm;
	private Donacion donacion;
	private double monto;
	private String numtarjeta;
	private String mesexpira;
	private String anioexpira;
	private String nomtarjeta;
	private String descripcion;
	private int cantidad;
	private double valorunitario;
	private double total;
	
	public DonacionDetalleViewModel(int rowIndex, long id, Tipodnm tipodnm, Donacion donacion, double monto,
			String numtarjeta, String mesexpira, String anioexpira, String nomtarjeta, String descripcion, int cantidad,
			double valorunitario, double total) {
		super();
		this.rowIndex = rowIndex;
		this.id = id;
		this.tipodnm = tipodnm;
		this.donacion = donacion;
		this.monto = monto;
		this.numtarjeta = numtarjeta;
		this.mesexpira = mesexpira;
		this.anioexpira = anioexpira;
		this.nomtarjeta = nomtarjeta;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.valorunitario = valorunitario;
		this.total = total;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
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

	public Donacion getDonacion() {
		return donacion;
	}

	public void setDonacion(Donacion donacion) {
		this.donacion = donacion;
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
