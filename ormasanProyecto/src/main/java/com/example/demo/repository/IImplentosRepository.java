package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Implemento_Seguridad;

@Repository
public interface IImplentosRepository extends JpaRepository<Implemento_Seguridad, Integer> {
public Implemento_Seguridad	findByIdImplemento(Integer idImplemento);
}
