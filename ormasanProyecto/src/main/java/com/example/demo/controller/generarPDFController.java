package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.demo.models.Costeo;
import com.example.demo.models.view.Vista_costeo_gastos_fijos;
import com.example.demo.models.view.Vista_costeo_implementos;
import com.example.demo.models.view.Vista_costeo_materiales;
import com.example.demo.models.view.Vista_costeo_servicios;
import com.example.demo.repository.ICosteoRepository;
import com.example.demo.repositoryView.Vista_costeo_gastosFijosRepository;
import com.example.demo.repositoryView.Vista_costeo_implementosRepository;
import com.example.demo.repositoryView.Vista_costeo_materialesRepository;
import com.example.demo.repositoryView.Vista_costeo_servicioRepository;
import com.example.demo.service.CosteoPDFService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/filesPDF")
public class generarPDFController {

	@Autowired
	Vista_costeo_gastosFijosRepository fijo;
	@Autowired
	Vista_costeo_materialesRepository materiales;
	@Autowired
	Vista_costeo_implementosRepository implementos;
	@Autowired
	Vista_costeo_servicioRepository servicios;
	
	@Autowired
	CosteoPDFService pdf;
	@Autowired
	ICosteoRepository costeo;
	
@GetMapping("generarPDF/{IDCosteo}/{IDtrabajo}")
public void generar(@PathVariable int IDCosteo,@PathVariable int IDtrabajo,HttpServletResponse response, HttpSession session) {
	
	try {
		  response.setContentType("application/pdf");
	        response.setHeader("Content-Disposition", "attachment; filename=CosteoCompleto"+IDCosteo+".pdf");
         List<Vista_costeo_gastos_fijos> gFijo = fijo.findByIdTrabajo(IDtrabajo); 
         List<Vista_costeo_materiales> gMat = materiales.findByIdTrabajo(IDtrabajo); 
         List<Vista_costeo_implementos> gImp = implementos.findByIdTrabajo(IDtrabajo); 
         List<Vista_costeo_servicios> gServ = servicios.findByIdTrabajo(IDtrabajo); 
         Optional<Costeo> cos = costeo.findById(IDCosteo); 
         
         System.out.println("===== DATOS RECUPERADOS =====");

      // Costos Fijos
      System.out.println(">> Costos Fijos:");
      if (gFijo != null && !gFijo.isEmpty()) {
          gFijo.forEach(g -> System.out.println("  - " + g.getDescripcionGastoFijo()));
      } else {
          System.out.println("  (sin datos)");
      }

      // Materiales
      System.out.println(">> Materiales:");
      if (gMat != null && !gMat.isEmpty()) {
          gMat.forEach(g -> System.out.println("  - " + g.getNombreMaterial()));
      } else {
          System.out.println("  (sin datos)");
      }

      // Implementos
      System.out.println(">> Implementos:");
      if (gImp != null && !gImp.isEmpty()) {
          gImp.forEach(g -> System.out.println("  - " + g.getNombreImplemento()));
      } else {
          System.out.println("  (sin datos)");
      }

      // Servicios
      System.out.println(">> Servicios:");
      if (gServ != null && !gServ.isEmpty()) {
          gServ.forEach(g -> System.out.println("  - " + g.getNombreServicio()));
      } else {
          System.out.println("  (sin datos)");
      }

      // Costeo (opcional)
      System.out.println(">> Datos Costeo:");
      if (cos.isPresent()) {
          System.out.println("  - " + cos.get().getIdCosteo());
      } else {
          System.out.println("  (no encontrado)");
      }
         
         
         pdf.exportarPDF(gImp, gMat, gServ, gFijo, cos.get(),response.getOutputStream());
      
        session.removeAttribute("IDtrabajo");
         
         session.removeAttribute("IDCosteo");
         session.removeAttribute("indicadorFinanciero");
	}catch(Exception e){
	
	}
	
	
	
	
}
}
