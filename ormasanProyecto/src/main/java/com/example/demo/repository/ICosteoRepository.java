package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Costeo;
@Repository
public interface ICosteoRepository extends JpaRepository<Costeo, Integer>{
	@Query("SELECT c.idCosteo FROM Costeo c WHERE c.trabajo.idTrabajo = :idTrabajo")	
	public Integer findIdCosteoByTrabajoIdTrabajo(Integer idTrabajo);
}
