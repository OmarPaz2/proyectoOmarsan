package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Equipo;

public interface IEquipoRepository extends JpaRepository<Equipo, Integer> {
public List<Equipo> findByZonaIdZona(Integer idZona);
public Equipo findByIdEquipo(Integer idEquipo);
}
