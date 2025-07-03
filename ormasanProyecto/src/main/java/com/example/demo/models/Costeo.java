package com.example.demo.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="Costeo")
public class Costeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCosteo;

  
    private double gastoFijo;
    private double gastoVariable;

    @ManyToOne
    @JoinColumn(name = "idTrabajo", nullable = false)
    private Trabajo trabajo;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "costeo")
    private List<CostoFijo> costosFijos;

    @Transient
    public double getTotal() {
        return gastoFijo + gastoVariable;
    }

	public Integer getIdCosteo() {
		return idCosteo;
	}

	public void setIdCosteo(Integer idCosteo) {
		this.idCosteo = idCosteo;
	}

	

	public double getGastoFijo() {
		return gastoFijo;
	}

	public void setGastoFijo(double gastoFijo) {
		this.gastoFijo = gastoFijo;
	}

	public double getGastoVariable() {
		return gastoVariable;
	}

	public void setGastoVariable(double gastoVariable) {
		this.gastoVariable = gastoVariable;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<CostoFijo> getCostosFijos() {
		return costosFijos;
	}

	public void setCostosFijos(List<CostoFijo> costosFijos) {
		this.costosFijos = costosFijos;
	}
    
    
}
