package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ReporteTrabajo;

@Repository
public interface ReporteTrabajoRepository extends JpaRepository<ReporteTrabajo, Integer> {

}
