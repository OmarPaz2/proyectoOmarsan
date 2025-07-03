package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Trabajo;

@Repository
public interface ITrabajoRepository extends JpaRepository<Trabajo, Integer> {
	
@Query("SELECT t.idTrabajo FROM Trabajo t WHERE t.fecha = :fecha AND t.nombreTrabajo = :nombreTrabajo")	
public Integer findIdTrabajoByFechaAndNombreTrabajo(LocalDate fecha, String nombreTrabajo);
}
