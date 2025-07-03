package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="CostoFijo")
public class CostoFijo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCostoFijo;

    private String descripcion;
    private double monto;

    @ManyToOne
    @JoinColumn(name = "idCosteo", nullable = false)
    private Costeo costeo;

    //Propiedades
	public Integer getIdCostoFijo() {
		return idCostoFijo;
	}

	public void setIdCostoFijo(Integer idCostoFijo) {
		this.idCostoFijo = idCostoFijo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Costeo getCosteo() {
		return costeo;
	}

	public void setCosteo(Costeo costeo) {
		this.costeo = costeo;
	}
    
    
}
