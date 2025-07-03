package com.example.demo.models;

import com.example.demo.modelscompuesto.Costeo_ServicioId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name="Costeo_Servicio")
public class Costeo_Servicio {
	   @EmbeddedId
	    private Costeo_ServicioId id;


	    private int cantidad;
	    private double costoTotal;

	    @ManyToOne
	    @MapsId("idCosteo")
	    @JoinColumn(name = "idCosteo")
	    private Costeo costeo;

	    @ManyToOne
	    @MapsId("idServicio")
	    @JoinColumn(name = "idServicio")
	    private Servicio servicio;

		

		public Costeo_ServicioId getId() {
			return id;
		}

		public void setId(Costeo_ServicioId id) {
			this.id = id;
		}

		public int getCantidad() {
			return cantidad;
		}

		public void setCantidad(int cantidad) {
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

		public Servicio getServicio() {
			return servicio;
		}

		public void setServicio(Servicio servicio) {
			this.servicio = servicio;
		}
	    
	    
	    
	    
}
