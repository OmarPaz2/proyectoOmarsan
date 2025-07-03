package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Costeo_Servicio;
import com.example.demo.modelscompuesto.Costeo_ServicioId;
@Repository
public interface ICosteo_ServicioRepository extends JpaRepository<Costeo_Servicio, Costeo_ServicioId>{

	public List<Costeo_Servicio> findByCosteoIdCosteo(Integer idCosteo);
}
