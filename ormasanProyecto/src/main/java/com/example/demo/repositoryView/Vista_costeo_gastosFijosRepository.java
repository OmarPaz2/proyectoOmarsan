package com.example.demo.repositoryView;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.view.Vista_costeo_gastos_fijos;

@Repository
public interface Vista_costeo_gastosFijosRepository extends JpaRepository<Vista_costeo_gastos_fijos, Integer> {
	
	public List<Vista_costeo_gastos_fijos> findByIdTrabajo(Integer idTrabajo);

}
