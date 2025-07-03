package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Costeo_Material;
import com.example.demo.modelscompuesto.Costeo_MaterialCom;

@Repository
public interface ICosteo_MaterialRepository extends JpaRepository<Costeo_Material, Costeo_MaterialCom>{
	public List<Costeo_Material> findByCosteoIdCosteo(Integer idCosteo);
}
