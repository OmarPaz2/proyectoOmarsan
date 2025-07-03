package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Costeo_Implemento;
import com.example.demo.modelscompuesto.CosteoImplementocom;

@Repository
public interface ICosteo_ImplementoRepository extends JpaRepository<Costeo_Implemento, CosteoImplementocom>{
	public List<Costeo_Implemento> findByCosteoIdCosteo(Integer idCosteo);
}
