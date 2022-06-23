package com.ayudaperu.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipodocumento")
public class Tipodocumento {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long idtipodoc ;

		private String nombre;
		
		

		public Tipodocumento() {
			
		}



		public long getIdtipodoc() {
			return idtipodoc;
		}


		public void setIdtipodoc(long idtipodoc) {
			this.idtipodoc = idtipodoc;
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



		public Tipodocumento(long idtipodoc, String nombre) {
			super();
			this.idtipodoc = idtipodoc;
			this.nombre = nombre;
		}

		

		
}
