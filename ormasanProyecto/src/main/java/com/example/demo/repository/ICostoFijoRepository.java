package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CostoFijo;

@Repository
public interface ICostoFijoRepository extends JpaRepository<CostoFijo, Integer> {
	public List<CostoFijo>findByCosteoIdCosteo(Integer idCosteo);
}
