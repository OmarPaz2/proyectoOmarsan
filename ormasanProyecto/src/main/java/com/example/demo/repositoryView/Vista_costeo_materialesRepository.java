package com.example.demo.repositoryView;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.view.Vista_costeo_materiales;

@Repository
public interface Vista_costeo_materialesRepository extends JpaRepository<Vista_costeo_materiales, Integer> {
public List<Vista_costeo_materiales> findByIdTrabajo(Integer idTrabajo);
}
