package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="IndicadorFinanciero")
public class IndicadorFinanciero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIndicador;

    private double gananciaEsperada;
    private double margenGanancia;
    private double puntoEquilibrio;
    private double rentabilidad;

    @OneToOne
    @JoinColumn(name = "idCosteo", nullable = false)
    private Costeo costeo;

    //Propiedades
	public Integer getIdIndicador() {
		return idIndicador;
	}

	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	public double getGananciaEsperada() {
		return gananciaEsperada;
	}

	public void setGananciaEsperada(double gananciaEsperada) {
		this.gananciaEsperada = gananciaEsperada;
	}

	public double getMargenGanancia() {
		return margenGanancia;
	}

	public void setMargenGanancia(double margenGanancia) {
		this.margenGanancia = margenGanancia;
	}

	public double getPuntoEquilibrio() {
		return puntoEquilibrio;
	}

	public void setPuntoEquilibrio(double puntoEquilibrio) {
		this.puntoEquilibrio = puntoEquilibrio;
	}

	public double getRentabilidad() {
		return rentabilidad;
	}

	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}

	public Costeo getCosteo() {
		return costeo;
	}

	public void setCosteo(Costeo costeo) {
		this.costeo = costeo;
	}
    
    
}
