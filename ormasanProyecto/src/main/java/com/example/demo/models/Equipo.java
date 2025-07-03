package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idEquipo;

	    private String nombreEquipo;
	    private String descripcion;

	    @ManyToOne
	    @JoinColumn(name = "idZona", nullable = false)
	    private ZonaTrabajo zona;

	  //Propiedades
		public Integer getIdEquipo() {
			return idEquipo;
		}

		public void setIdEquipo(Integer idEquipo) {
			this.idEquipo = idEquipo;
		}

		public String getNombreEquipo() {
			return nombreEquipo;
		}

		public void setNombreEquipo(String nombreEquipo) {
			this.nombreEquipo = nombreEquipo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public ZonaTrabajo getZona() {
			return zona;
		}

		public void setZona(ZonaTrabajo zona) {
			this.zona = zona;
		}
	    
	    
	    
	    
}
