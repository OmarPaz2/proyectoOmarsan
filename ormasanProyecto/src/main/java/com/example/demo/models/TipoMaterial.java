package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoMaterial")
public class TipoMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoMaterial;

    private String nombreTipo;

    @OneToMany(mappedBy = "tipoMaterial")
    private List<Material> materiales;

    //Propiedades
	public Integer getIdTipoMaterial() {
		return idTipoMaterial;
	}

	public void setIdTipoMaterial(Integer idTipoMaterial) {
		this.idTipoMaterial = idTipoMaterial;
	}

	public String getNombreTipo() {
		return nombreTipo;
	}

	public void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}

	public List<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	}
    
    
}
