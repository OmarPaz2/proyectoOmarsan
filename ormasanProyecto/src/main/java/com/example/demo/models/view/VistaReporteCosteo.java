package com.example.demo.models.view;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Immutable
@Table(name = "VistaReporteCosteo")
public class VistaReporteCosteo {
	@Id
	private Long idIndicador;
	private Long idZona;
	private String nombreTrabajo;
	@Column(name = "fecha")
	private LocalDate fecha;
	private String zonaTrabajo;
	private BigDecimal costoFijo;
	private BigDecimal costoVariable;
	private BigDecimal costoTotal;
	private BigDecimal gananciaObtenida;
	private BigDecimal margenGanancia;
	private BigDecimal rentabilidad;
	

	// Getters únicamente
	public Long getIdZona() {
		return idZona;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getZonaTrabajo() {
		return zonaTrabajo;
	}

	public BigDecimal getCostoFijo() {
		return costoFijo;
	}

	public BigDecimal getCostoVariable() {
		return costoVariable;
	}

	public BigDecimal getCostoTotal() {
		return costoTotal;
	}

	public BigDecimal getGananciaObtenida() {
		return gananciaObtenida;
	}

	public BigDecimal getMargenGanancia() {
		return margenGanancia;
	}

	public BigDecimal getRentabilidad() {
		return rentabilidad;
	}

	public Long getIdIndicador() {
		return idIndicador;
	}

	
	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	
	
	
	
	
}