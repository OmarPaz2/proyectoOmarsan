package com.example.demo.modelscompuesto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
@Embeddable
public class Costeo_MaterialCom implements Serializable{
	 private Integer idCosteo;
	    private Integer idMaterial;

	    public Costeo_MaterialCom() {}

	    
	    
		public Costeo_MaterialCom(Integer idCosteo, Integer idMaterial) {
			super();
			this.idCosteo = idCosteo;
			this.idMaterial = idMaterial;
		}



		public Integer getIdCosteo() {
			return idCosteo;
		}

		public void setIdCosteo(Integer idCosteo) {
			this.idCosteo = idCosteo;
		}

		public Integer getIdMaterial() {
			return idMaterial;
		}

		public void setIdMaterial(Integer idMaterial) {
			this.idMaterial = idMaterial;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof Costeo_MaterialCom)) return false;
	        Costeo_MaterialCom that = (Costeo_MaterialCom) o;
	        return Objects.equals(idCosteo, that.idCosteo) &&
	               Objects.equals(idMaterial, that.idMaterial);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idCosteo, idMaterial);
	    }
}
