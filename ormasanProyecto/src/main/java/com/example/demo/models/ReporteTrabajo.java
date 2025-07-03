package com.example.demo.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ReporteTrabajo")
public class ReporteTrabajo {

	@Id
	private int idReporte;
	private LocalDate fecha;
	private String zonaTrabajo;
	private BigDecimal costoFijo;
	private BigDecimal costoVariable;
	private BigDecimal costoTotal;
	private BigDecimal gananciaObtenida;
	private BigDecimal margenGanancia;
	private BigDecimal rentabilidad;
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getZonaTrabajo() {
		return zonaTrabajo;
	}
	public void setZonaTrabajo(String zonaTrabajo) {
		this.zonaTrabajo = zonaTrabajo;
	}
	public BigDecimal getCostoFijo() {
		return costoFijo;
	}
	public void setCostoFijo(BigDecimal costoFijo) {
		this.costoFijo = costoFijo;
	}
	public BigDecimal getCostoVariable() {
		return costoVariable;
	}
	public void setCostoVariable(BigDecimal costoVariable) {
		this.costoVariable = costoVariable;
	}
	public BigDecimal getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(BigDecimal costoTotal) {
		this.costoTotal = costoTotal;
	}
	public BigDecimal getGananciaObtenida() {
		return gananciaObtenida;
	}
	public void setGananciaObtenida(BigDecimal gananciaObtenida) {
		this.gananciaObtenida = gananciaObtenida;
	}
	public BigDecimal getMargenGanancia() {
		return margenGanancia;
	}
	public void setMargenGanancia(BigDecimal margenGanancia) {
		this.margenGanancia = margenGanancia;
	}
	public BigDecimal getRentabilidad() {
		return rentabilidad;
	}
	public void setRentabilidad(BigDecimal rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	
	 

}
