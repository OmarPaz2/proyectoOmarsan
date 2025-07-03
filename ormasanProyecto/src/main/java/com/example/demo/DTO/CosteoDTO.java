package com.example.demo.DTO;


import java.time.LocalDate;

public class CosteoDTO {
	private Integer idCosteo,idTrabajo;
	    private LocalDate fechaTrabajo;
	    private Integer idEquipoTrabajo;
	    private String nombreTrabajo;
	    private Double cantidadTrabajada;
	    private String unidadMedidaTrabajo;
	    private int diasTrabajados;
	    private Double gastoFijoCosteo;
	    private Double gastoVariableCosteo;
	    private Integer idUsuarioCosteo;
	    private String descripcionFijo;
	    private Double montoFijo;
	    private Integer idMaterial;
	    private Double cantidadMaterial;
	    private Double costoTotalMaterial;
	    private Integer idImplemento;
	    private Double cantidadImplemento;
	    private Double costoTotalImplemento;
	    private Integer idServicio;
	    private int cantidadServicio;
	    private Double costoTotalServicio;
	    
	    public CosteoDTO() {
	      
	    }

		public Integer getIdCosteo() {
			return idCosteo;
		}

		public void setIdCosteo(Integer idCosteo) {
			this.idCosteo = idCosteo;
		}

		public Integer getIdTrabajo() {
			return idTrabajo;
		}

		public void setIdTrabajo(Integer idTrabajo) {
			this.idTrabajo = idTrabajo;
		}

		public LocalDate getFechaTrabajo() {
			return fechaTrabajo;
		}

		public void setFechaTrabajo(LocalDate fechaTrabajo) {
			this.fechaTrabajo = fechaTrabajo;
		}

		public Integer getIdEquipoTrabajo() {
			return idEquipoTrabajo;
		}

		public void setIdEquipoTrabajo(Integer idEquipoTrabajo) {
			this.idEquipoTrabajo = idEquipoTrabajo;
		}

		public String getNombreTrabajo() {
			return nombreTrabajo;
		}

		public void setNombreTrabajo(String nombreTrabajo) {
			this.nombreTrabajo = nombreTrabajo;
		}

		public Double getCantidadTrabajada() {
			return cantidadTrabajada;
		}

		public void setCantidadTrabajada(Double cantidadTrabajada) {
			this.cantidadTrabajada = cantidadTrabajada;
		}

		public String getUnidadMedidaTrabajo() {
			return unidadMedidaTrabajo;
		}

		public void setUnidadMedidaTrabajo(String unidadMedidaTrabajo) {
			this.unidadMedidaTrabajo = unidadMedidaTrabajo;
		}

		public int getDiasTrabajados() {
			return diasTrabajados;
		}

		public void setDiasTrabajados(int diasTrabajados) {
			this.diasTrabajados = diasTrabajados;
		}

		public Double getGastoFijoCosteo() {
			return gastoFijoCosteo;
		}

		public void setGastoFijoCosteo(Double gastoFijoCosteo) {
			this.gastoFijoCosteo = gastoFijoCosteo;
		}

		public Double getGastoVariableCosteo() {
			return gastoVariableCosteo;
		}

		public void setGastoVariableCosteo(Double gastoVariableCosteo) {
			this.gastoVariableCosteo = gastoVariableCosteo;
		}

		public Integer getIdUsuarioCosteo() {
			return idUsuarioCosteo;
		}

		public void setIdUsuarioCosteo(Integer idUsuarioCosteo) {
			this.idUsuarioCosteo = idUsuarioCosteo;
		}

		public String getDescripcionFijo() {
			return descripcionFijo;
		}

		public void setDescripcionFijo(String descripcionFijo) {
			this.descripcionFijo = descripcionFijo;
		}

		public Double getMontoFijo() {
			return montoFijo;
		}

		public void setMontoFijo(Double montoFijo) {
			this.montoFijo = montoFijo;
		}

		public Integer getIdMaterial() {
			return idMaterial;
		}

		public void setIdMaterial(Integer idMaterial) {
			this.idMaterial = idMaterial;
		}

		public Double getCantidadMaterial() {
			return cantidadMaterial;
		}

		public void setCantidadMaterial(Double cantidadMaterial) {
			this.cantidadMaterial = cantidadMaterial;
		}

		public Double getCostoTotalMaterial() {
			return costoTotalMaterial;
		}

		public void setCostoTotalMaterial(Double costoTotalMaterial) {
			this.costoTotalMaterial = costoTotalMaterial;
		}

		public Integer getIdImplemento() {
			return idImplemento;
		}

		public void setIdImplemento(Integer idImplemento) {
			this.idImplemento = idImplemento;
		}

		public Double getCantidadImplemento() {
			return cantidadImplemento;
		}

		public void setCantidadImplemento(Double cantidadImplemento) {
			this.cantidadImplemento = cantidadImplemento;
		}

		public Double getCostoTotalImplemento() {
			return costoTotalImplemento;
		}

		public void setCostoTotalImplemento(Double costoTotalImplemento) {
			this.costoTotalImplemento = costoTotalImplemento;
		}

		public Integer getIdServicio() {
			return idServicio;
		}

		public void setIdServicio(Integer idServicio) {
			this.idServicio = idServicio;
		}

		public int getCantidadServicio() {
			return cantidadServicio;
		}

		public void setCantidadServicio(int cantidadServicio) {
			this.cantidadServicio = cantidadServicio;
		}

		public Double getCostoTotalServicio() {
			return costoTotalServicio;
		}

		public void setCostoTotalServicio(Double costoTotalServicio) {
			this.costoTotalServicio = costoTotalServicio;
		}
	    
	    

	    
	    
}
