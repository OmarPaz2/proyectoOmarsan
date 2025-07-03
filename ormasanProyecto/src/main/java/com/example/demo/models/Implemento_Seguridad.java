package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="implemento_Seguridad")
public class Implemento_Seguridad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImplemento;

    private String nombreImp;
    @Column(name = "costo_unit")
    private Double costoUnit;
    private String unidadMedida;

    @ManyToOne
    @JoinColumn(name = "idTipo", nullable = false)
    private TipoImpSeguridad tipo;

    //Propiedades
	public Integer getIdImplemento() {
		return idImplemento;
	}

	public void setIdImplemento(Integer idImplemento) {
		this.idImplemento = idImplemento;
	}

	public String getNombreImp() {
		return nombreImp;
	}

	public void setNombreImp(String nombreImp) {
		this.nombreImp = nombreImp;
	}

	public Double  getCostoUnit() {
		return costoUnit;
	}

	public void setCostoUnit(Double  costoUnit) {
		this.costoUnit = costoUnit;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public TipoImpSeguridad getTipo() {
		return tipo;
	}

	public void setTipo(TipoImpSeguridad tipo) {
		this.tipo = tipo;
	}
    
    
}
