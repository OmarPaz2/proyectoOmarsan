package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Implemento_Seguridad;
import com.example.demo.repository.IImplentosRepository;

@Service
public class ImplementosService {
@Autowired
private IImplentosRepository implementos;

public double obtenerCostosImplementos(Integer idImplemento, int cantidad) {
	 Implemento_Seguridad imp = implementos.findByIdImplemento(idImplemento);
     double suma = imp.getCostoUnit() * cantidad;
     System.out.println("desde el service: "+suma);
     return suma;
}
}
