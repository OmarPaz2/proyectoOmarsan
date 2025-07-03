package com.example.demo.models;

import com.example.demo.modelscompuesto.Costeo_MaterialCom;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="Costeo_Material")
public class Costeo_Material {
   @EmbeddedId
   private Costeo_MaterialCom id; 

    private double cantidad;
    private double costoTotal;
    
    @ManyToOne
    @MapsId("idCosteo")
    @JoinColumn(name = "idCosteo")
    private Costeo costeo;

    @ManyToOne
    @MapsId("idMaterial")
    @JoinColumn(name = "idMaterial")
    private Material material;
    
//Propiedades
	public Costeo_MaterialCom getId() {
		return id;
	}

	public void setId(Costeo_MaterialCom id) {
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
    
    
}
