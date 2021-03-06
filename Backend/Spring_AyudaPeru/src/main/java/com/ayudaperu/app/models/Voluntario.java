package com.ayudaperu.app.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "voluntarios")
public class Voluntario {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	 @OneToOne private Pais pais;
	 @OneToOne private Tipodocumento  tipoDocumento;
	 

	@Column(name = "nombre", length = 60, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 60, nullable = false)
	private String apellido;

	@Column(name = "numerodoc", length = 60, nullable = false)
	private String numerodoc;

	@Column(name = "direccion", length = 60, nullable = false)
	private String direccion;

	@Column(name = "telefono", length = 60, nullable = false)
	private String telefono;

	@Column(name = "email", length = 60, nullable = false, unique = true)
	private String email;

	@Column(name = "estado")
	private boolean estado;

	public Voluntario() {

	}

	public Voluntario(long id, String nombre, String apellido, Tipodocumento tipoDocumento, String numeroDocumento,
			String direccion, String telefono, String email, boolean estado, Pais pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.numerodoc = numeroDocumento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.estado = estado;
		this.pais = pais;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	 public Pais getPais() { return pais; }
	  
	 public void setPais(Pais pais) { this.pais = pais; }
	 

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Tipodocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Tipodocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	

	public String getNumeroDocumento() {
		return numerodoc;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numerodoc = numeroDocumento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
