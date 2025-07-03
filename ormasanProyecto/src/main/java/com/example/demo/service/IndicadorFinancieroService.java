package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Costeo;
import com.example.demo.models.Costeo_Implemento;
import com.example.demo.models.Costeo_Material;
import com.example.demo.models.Costeo_Servicio;
import com.example.demo.models.CostoFijo;
import com.example.demo.models.Trabajo;
import com.example.demo.repository.ICosteoRepository;
import com.example.demo.repository.ICosteo_ImplementoRepository;
import com.example.demo.repository.ICosteo_MaterialRepository;
import com.example.demo.repository.ICosteo_ServicioRepository;
import com.example.demo.repository.ICostoFijoRepository;
import com.example.demo.repository.ITrabajoRepository;
@Service
public class IndicadorFinancieroService {
/* 
 - GANANCIA ESPERADA
 - VALOR INTERNO DEL TRABAJO
 - COSTO TOTAL DEL SERVICIO
 - MARGEN DE GANANCIA
 - PUNTO DE EQUILIBRIO
 - COSTO VARIABLE UNITARIO
 - RENTABILIDAD
 */
	@Autowired
	ICosteoRepository costeo;
	@Autowired
	ITrabajoRepository trabajo;
	@Autowired
	ICosteo_ServicioRepository servicio;
	@Autowired
	ICosteo_MaterialRepository materialesRepository;
	@Autowired
	ICosteo_ImplementoRepository implementosRepository;
	@Autowired
	ICostoFijoRepository fijoRepository;
	
	
	
	public double costoTotalServicio(Integer idCosteo) {
		Optional<Costeo> objCosteo = costeo.findById(idCosteo);
		double totalCosteoBD = objCosteo.get().getTotal();
		
		return totalCosteoBD;
	}
	//Valor interno del trabajo
	public double valorInternoTrabajo(int idTrabajo) {
		Optional<Trabajo> job = trabajo.findById(idTrabajo);
		Integer cos = costeo.findIdCosteoByTrabajoIdTrabajo(idTrabajo);
		List<Costeo_Servicio> serv = servicio.findByCosteoIdCosteo(cos);
		
		int dias = job.get().getDiasTrabajados();
		double cantidad = job.get().getCantidadTrabajada();
		double total=0;
		System.out.println("SERVICIO ES DAA: " + serv);
		if(dias >= 10) {
			 total = cantidad * 9;	
		}else if(dias < 10 && serv.isEmpty()){
			total = cantidad * 6.5;
		}else {
			if(serv.size() == 1) {
				total = cantidad * 8.2;	
			}else if(serv.size() > 1)
				total = cantidad * 10;
			
		}
		return total;
				
	}
	
	public double gananciaEsperada(double valorInterno, double costoTotal) {
		return valorInterno - costoTotal;
	}
	
	//Margen de ganancia
	
	public double margenGanancia(double gananciaEsperada, double valorInterno) {
		return (gananciaEsperada/valorInterno) * 100;
	}
	
	//Costo VARIABLE UNITARIO
	
	public double costoVariableUnitario(int idCosteo) {
		Optional<Costeo> cos = costeo.findById(idCosteo);
		double Cvariable = cos.get().getGastoVariable();
		Trabajo objJob = cos.get().getTrabajo();
		
		double cantidad=objJob.getCantidadTrabajada();
		
		return Cvariable/cantidad;
	}
	
	//RENTABILIDAD
	
	public double rentabilidad(double gananciaEsperada,double costoTotalServ) {
		return (gananciaEsperada/costoTotalServ)*100;
	}
	
	//PUNTO DE EQUILIBRIO
	
	public double puntoEquilibrio(int idCosteo,double valorInternoTrabajo, double costoVarUni) {
		Optional<Costeo> cos = costeo.findById(idCosteo);
		Trabajo job = cos.get().getTrabajo();
		double cantidad = job.getCantidadTrabajada();
		
		//para la operacion
		
		double tarifa = valorInternoTrabajo/cantidad;
		double Cfijo = cos.get().getGastoFijo();
		
		return Cfijo/(tarifa-costoVarUni);
	}
	
	//Costo variable total
	
	public void costoVariableTotal(int idCosteo) {
		List<Costeo_Servicio> serv = servicio.findByCosteoIdCosteo(idCosteo);
		List<Costeo_Implemento> imple = implementosRepository.findByCosteoIdCosteo(idCosteo); 
		List<Costeo_Material> material = materialesRepository.findByCosteoIdCosteo(idCosteo);
		double totalVariable = 0;
		
		double totalservicio=0;
		double totalmaterial = 0;
		double totalimplemento = 0; 
		if(serv !=null) {
			
			for(Costeo_Servicio sv : serv) {
				totalservicio +=sv.getCostoTotal();
			}
			
		}
		if(imple !=null) {	
			
			
			for(Costeo_Material m : material) {
				totalmaterial +=m.getCostoTotal();
			}
		}
		
		if(material !=null) {
			
			for(Costeo_Implemento im : imple) {
				totalimplemento += im.getCostoTotal();
			}
		}
		Optional<Costeo> cos = costeo.findById(idCosteo);
		totalVariable = totalservicio + totalmaterial + totalimplemento;
		cos.get().setGastoVariable(totalVariable);
		costeo.save(cos.get());
		
	}
	
	//Costo fijo total
	public void costoFijoTotal(int idCosteo) {
		List<CostoFijo> fijo = fijoRepository.findByCosteoIdCosteo(idCosteo);		
		
		double totalFijo=0;
	
		if(fijo !=null) {
			
			for(CostoFijo fij : fijo) {
				totalFijo +=fij.getMonto();
			}
			
		}
		
		Optional<Costeo> cos = costeo.findById(idCosteo);
		
		cos.get().setGastoFijo(totalFijo);
		costeo.save(cos.get());
		
	}
	
}
