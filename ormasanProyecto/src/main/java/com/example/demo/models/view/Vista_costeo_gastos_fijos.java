package com.example.demo.models.view;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vista_costeo_gastos_fijos")
public class Vista_costeo_gastos_fijos {

	@Id
	 private int idCostoFijo;
	 private int idTrabajo;
	 private String nombreZona;
	 private String nombreEquipo;
	 private String nombreTrabajo;
	 private LocalDate fechaTrabajo;
	 private double cantidadTrabajada;
	 private String unidadMedida;
	 private int diasTrabajados;
	 private String descripcionGastoFijo;
	 private double montoGastoFijo;
	 
	 
	 public int getIdCostoFijo() {
		return idCostoFijo;
	}
	 public int getIdTrabajo() {
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
	 public String getDescripcionGastoFijo() {
		 return descripcionGastoFijo;
	 }
	 public double getMontoGastoFijo() {
		 return montoGastoFijo;
	 }
	 
	 
}
