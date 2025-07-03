package com.example.demo.models.view;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vista_costeo_implementos")
public class Vista_costeo_implementos {

	@Id
    private Integer idImplemento;
	private Integer idTrabajo;
	private String nombreZona;
    private String nombreEquipo;
    private String nombreTrabajo;
    private LocalDate fechaTrabajo;
    private Double cantidadTrabajada;
    private String unidadMedida;
    private int diasTrabajados;
    private String nombreImplemento;
    private int cantidadImplemento;
    private double costoImplementoTotal;
    
	public Integer getIdImplemento() {
		return idImplemento;
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
	public Double getCantidadTrabajada() {
		return cantidadTrabajada;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public int getDiasTrabajados() {
		return diasTrabajados;
	}
	public String getNombreImplemento() {
		return nombreImplemento;
	}
	public int getCantidadImplemento() {
		return cantidadImplemento;
	}
	public double getCostoImplementoTotal() {
		return costoImplementoTotal;
	}
    
    
}
