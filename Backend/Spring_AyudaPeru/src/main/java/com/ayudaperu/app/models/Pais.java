package com.ayudaperu.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Pais {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idpais ;

	private String nombrepais;
	
	

	public Pais() {
		
	}

	public Pais(long idpais, String nombrepais) {
		super();
		this.idpais = idpais;
		this.nombrepais = nombrepais;
	}

	public long getIdpais() {
		return idpais;
	}

	public void setIdpais(long idpais) {
		this.idpais = idpais;
	}

	public String getNombrepais() {
		return nombrepais;
	}

	public void setNombrepais(String nombrepais) {
		this.nombrepais = nombrepais;
	}


	
	
	
	

}
