package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TipoMaterial;

@Repository
public interface ITipoMaterialRepository  extends JpaRepository<TipoMaterial, Integer> {

}
