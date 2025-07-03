package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Material;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Long> {
public Material findByIdMaterial(Integer idMaterial);
}
