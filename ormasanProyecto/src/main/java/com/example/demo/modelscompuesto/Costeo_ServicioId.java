package com.example.demo.modelscompuesto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class Costeo_ServicioId implements Serializable {
	private Integer idCosteo;
    private Integer idServicio;

    public Costeo_ServicioId() {}

    
    public Costeo_ServicioId(Integer idCosteo, Integer idServicio) {
		super();
		this.idCosteo = idCosteo;
		this.idServicio = idServicio;
	}


	public Integer getIdCosteo() {
		return idCosteo;
	}


	public void setIdCosteo(Integer idCosteo) {
		this.idCosteo = idCosteo;
	}


	public Integer getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Costeo_ServicioId)) return false;
        Costeo_ServicioId that = (Costeo_ServicioId) o;
        return Objects.equals(idCosteo, that.idCosteo) &&
               Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCosteo, idServicio);
    }
}
