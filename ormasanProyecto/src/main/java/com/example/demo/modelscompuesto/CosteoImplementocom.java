package com.example.demo.modelscompuesto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
//como es una tabla compuesta es necesario hacer esto para hibernate 
//lo renocozca y no bote error
@Embeddable
public class CosteoImplementocom implements Serializable{
	    private Integer idCosteo;
	    private Integer idImplemento;

	    
	    public CosteoImplementocom() {}

	    
	    
	    public CosteoImplementocom(Integer idCosteo, Integer idImplemento) {
			super();
			this.idCosteo = idCosteo;
			this.idImplemento = idImplemento;
		}



		public Integer getIdCosteo() {
			return idCosteo;
		}



		public void setIdCosteo(Integer idCosteo) {
			this.idCosteo = idCosteo;
		}



		public Integer getIdImplemento() {
			return idImplemento;
		}



		public void setIdImplemento(Integer idImplemento) {
			this.idImplemento = idImplemento;
		}



		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof CosteoImplementocom)) return false;
	        CosteoImplementocom that = (CosteoImplementocom) o;
	        return Objects.equals(idCosteo, that.idCosteo) &&
	               Objects.equals(idImplemento, that.idImplemento);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(idCosteo, idImplemento);
	    }
}
