package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoImpSeguridad")
public class TipoImpSeguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;

    private String nombreTipo;

    @OneToMany(mappedBy = "tipo")
    private List<Implemento_Seguridad> implementos;

    //Propiedades
	public Integer getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Implemento_Seguridad> getImplementos() {
		return implementos;
	}

	public void setImplementos(List<Implemento_Seguridad> implementos) {
		this.implementos = implementos;
	}
    
    
}
