package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Material;
import com.example.demo.repository.IMaterialRepository;

@Service
public class MaterialService {
	 @Autowired
	    private IMaterialRepository materialRepository;

	    public double obtenerTotalCostoMateriales(Integer idMaterial,int cantidad) {
	        Material material = materialRepository.findByIdMaterial(idMaterial);
	        double suma = material.getCostoUnit() * cantidad;
	        return suma;
	    }
}
