package com.example.demo.repositoryView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.view.Vista_costeo_servicios;
import java.util.List;


@Repository
public interface Vista_costeo_servicioRepository extends JpaRepository<Vista_costeo_servicios, Integer> {

	public List<Vista_costeo_servicios> findByIdTrabajo(Integer idTrabajo);
}
