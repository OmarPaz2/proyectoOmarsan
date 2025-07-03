package com.example.demo.models.view;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vista_costeo_materiales")
public class Vista_costeo_materiales {

	@Id
	 private Integer idMaterial;
	 private Integer idTrabajo;
	 private String nombreZona;
	 private String nombreEquipo;
	 private String nombreTrabajo;
	 private LocalDate fecha;
	 private double cantidadTrabajada;
	 private String unidadMedida;
	 private int diasTrabajados;
	 private String nombreMaterial;
	 private double cantidad;
	 private double costoTotal;
	 
	 
	 public Integer getIdMaterial() {
		return idMaterial;
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
	 public LocalDate getFecha() {
		 return fecha;
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
	 public String getNombreMaterial() {
		 return nombreMaterial;
	 }
	 public double getCantidad() {
		 return cantidad;
	 }
	 public double getCostoTotal() {
		 return costoTotal;
	 }
	 
	 
}
