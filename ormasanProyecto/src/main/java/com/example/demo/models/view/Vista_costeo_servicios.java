package com.example.demo.models.view;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vista_costeo_servicios")
public class Vista_costeo_servicios {

	@Id
	 private Integer idServicio;
	private Integer idTrabajo;
	 private String  nombreZona;
	 private String nombreEquipo;
	 private String nombreTrabajo;
	 private LocalDate fechaTrabajo;
	 private double cantidadTrabajada;
	 private String unidadMedida;
	 private int diasTrabajados;
	 private String nombreServicio;
	 private int cantidadServicio;
	 private double costoServicioTotal;
	 
	 
	 public Integer getIdServicio() {
		return idServicio;
	}
	 public Integer getIdTrabajo() {
		 return idTrabajo;
	 }
	 public String getNombreZona() {
		 return nombreZona;
	 }
	 public String getNombreEquipo() {
		 return nombreEquipo;
	 }
	 public String getNombreTrabajo() {
		 return nombreTrabajo;
	 }
	 public LocalDate getFechaTrabajo() {
		 return fechaTrabajo;
	 }
	 public double getCantidadTrabajada() {
		 return cantidadTrabajada;
	 }
	 public String getUnidadMedida() {
		 return unidadMedida;
	 }
	 public int getDiasTrabajados() {
		 return diasTrabajados;
	 }
	 public String getNombreServicio() {
		 return nombreServicio;
	 }
	 public int getCantidadServicio() {
		 return cantidadServicio;
	 }
	 public double getCostoServicioTotal() {
		 return costoServicioTotal;
	 }
	 
	 
}
