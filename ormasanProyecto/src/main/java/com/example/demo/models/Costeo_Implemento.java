package com.example.demo.models;

import java.math.BigDecimal;

import com.example.demo.modelscompuesto.CosteoImplementocom;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="Costeo_Implemento")
public class Costeo_Implemento {
    @EmbeddedId
    private CosteoImplementocom id;
    
    private double cantidad;
    private double costoTotal;

    @ManyToOne
    @MapsId("idCosteo")
    @JoinColumn(name = "idCosteo")
    private Costeo costeo;

    @ManyToOne
    @MapsId("idImplemento")
    @JoinColumn(name = "idImplemento")
    private Implemento_Seguridad implemento;


	public CosteoImplementocom getId() {
		return id;
	}

	public void setId(CosteoImplementocom id) {
		this.id = id;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

	public Costeo getCosteo() {
		return costeo;
	}

	public void setCosteo(Costeo costeo) {
		this.costeo = costeo;
	}

	public Implemento_Seguridad getImplemento() {
		return implemento;
	}

	public void setImplemento(Implemento_Seguridad implemento) {
		this.implemento = implemento;
	}
    
    
}
