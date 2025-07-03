package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.DTO.CosteoDTO;
import com.example.demo.models.Costeo;
import com.example.demo.models.Costeo_Implemento;
import com.example.demo.models.Costeo_Material;
import com.example.demo.models.Costeo_Servicio;
import com.example.demo.models.CostoFijo;
import com.example.demo.models.Equipo;
import com.example.demo.models.Implemento_Seguridad;
import com.example.demo.models.IndicadorFinanciero;
import com.example.demo.models.Material;
import com.example.demo.models.Servicio;
import com.example.demo.models.Trabajo;
import com.example.demo.models.Usuario;
import com.example.demo.models.ZonaTrabajo;
import com.example.demo.modelscompuesto.CosteoImplementocom;
import com.example.demo.modelscompuesto.Costeo_MaterialCom;
import com.example.demo.modelscompuesto.Costeo_ServicioId;
import com.example.demo.repository.ICosteoRepository;
import com.example.demo.repository.ICosteo_MaterialRepository;
import com.example.demo.repository.ICosteo_ServicioRepository;
import com.example.demo.repository.ICostoFijoRepository;
import com.example.demo.repository.IEquipoRepository;
import com.example.demo.repository.ICosteo_ImplementoRepository;
import com.example.demo.repository.IImplentosRepository;
import com.example.demo.repository.IMaterialRepository;
import com.example.demo.repository.IServicioRepository;
import com.example.demo.repository.ITrabajoRepository;
import com.example.demo.repository.IUsuarioRepository;
import com.example.demo.repository.IZonaTrabajo;
import com.example.demo.repository.IindicadorFinancieroRepository;
import com.example.demo.service.ImplementosService;
import com.example.demo.service.IndicadorFinancieroService;
import com.example.demo.service.MaterialService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/trabajoCosteo")
public class CosteoController {

@Autowired
IZonaTrabajo zona;
@Autowired
IEquipoRepository equipo;

@Autowired
ITrabajoRepository Itrabajo;

@Autowired
IUsuarioRepository Iusuario;

@Autowired
ICosteoRepository Icosteo;

@Autowired
ICostoFijoRepository icostoFijo;

@Autowired
ICosteo_MaterialRepository icosteoMaterial;

@Autowired
ICosteo_ImplementoRepository iImpRepository;

@Autowired
ICosteo_ServicioRepository servicioRepository;

@Autowired
IindicadorFinancieroRepository indicadorRepository;

//servicio
@Autowired
MaterialService servicio;
@Autowired
ImplementosService impService;
@Autowired
IndicadorFinancieroService indicadorservice;
//Frm de gastos
@Autowired
IServicioRepository serv;
@Autowired
IMaterialRepository mater;
@Autowired
IImplentosRepository impSeguridad;

@GetMapping("/Costeo")
public String showCosteo(Model model, Integer idZona, HttpSession session) {
	List<ZonaTrabajo> lZona = zona.findAll();
	model.addAttribute("zonas",lZona);
	
	List<Servicio> lServicio = serv.findAll();
	model.addAttribute("servicios", lServicio);
	
	List<Material> lMaterial= mater.findAll();
	model.addAttribute("materiales", lMaterial);
	
	List<Implemento_Seguridad> limplementos= impSeguridad.findAll();
	model.addAttribute("implementos", limplementos);

	CosteoDTO costeoDTO = new CosteoDTO();
	
	
	if(idZona != null) {
		List<Equipo> lEquipo = equipo.findByZonaIdZona(idZona);
		model.addAttribute("equipos",lEquipo);
		model.addAttribute("zonaSeleccionada", idZona);
		System.out.println("si se ejecuta");
	}else
		System.out.println("no se ejecuta");
	
	Integer idCosteoSession=(Integer)session.getAttribute("IDCosteo");
	Integer idTrabajoSession = (Integer) session.getAttribute("IDtrabajo");
	
	if(idTrabajoSession !=null && idCosteoSession !=null) {
		
		model.addAttribute("IDtrabajo",idTrabajoSession);
		model.addAttribute("IDCosteo",idCosteoSession);
	}
	
	model.addAttribute("trabajos", costeoDTO);
	
	Optional<IndicadorFinanciero> indicador = indicadorRepository.findByCosteoIdCosteo(idCosteoSession);
	
	if(indicador.isPresent()) {
		model.addAttribute("indicadorFinanciero",indicador.get());	
	}
	
	if(idCosteoSession !=null) {
		Optional<Costeo> cos = Icosteo.findById(idCosteoSession);
		if(cos.isPresent()) {
			Double totalservicio = cos.get().getTotal();
			model.addAttribute("totalServicio",totalservicio);
		}
		
	}
	
	return "costeo";
}


@PostMapping("/Costeo")
public String RegistroTrabajo(@ModelAttribute  CosteoDTO trabajos, HttpSession session) {
	System.out.println("entre al metodo post");
	Integer idTrabajo = null; 
	Trabajo trabajo = null;
	Integer idCosteo = null; 
	Integer sessionIDCosteo = (Integer)session.getAttribute("IDCosteo");
	Usuario user = (Usuario) session.getAttribute("usuarioIniciado");
	trabajos.setIdUsuarioCosteo(user.getIdUsuario());
	//TRABAJO
	if(trabajos.getFechaTrabajo() !=null && (!trabajos.getNombreTrabajo().isEmpty() && trabajos.getNombreTrabajo() != null)) {
		 trabajo = new Trabajo();
		trabajo.setNombreTrabajo(trabajos.getNombreTrabajo());
		trabajo.setFecha(trabajos.getFechaTrabajo());
		Equipo equip = equipo.findByIdEquipo(trabajos.getIdEquipoTrabajo());
		trabajo.setEquipo(equip);
		trabajo.setCantidadTrabajada(trabajos.getCantidadTrabajada());
		trabajo.setUnidadMedida(trabajos.getUnidadMedidaTrabajo());
		trabajo.setDiasTrabajados(trabajos.getDiasTrabajados());
		
		Itrabajo.save(trabajo);
		
		 idTrabajo = Itrabajo.findIdTrabajoByFechaAndNombreTrabajo(trabajo.getFecha(), trabajo.getNombreTrabajo());
		
		System.out.println("iD TRABAJO:"+idTrabajo);
		session.setAttribute("IDtrabajo",idTrabajo);
	} else if (trabajos.getIdTrabajo() != null) {
	    idTrabajo = trabajos.getIdTrabajo();
	    trabajo = Itrabajo.findById(idTrabajo).orElse(null);
	}
	
	//COSTEO
	if(user !=null && idTrabajo !=null) {
		Costeo costeo = new Costeo();
		
		System.out.println("id: " + idTrabajo);
		System.out.println("Si hay trabajo: " + trabajo);
		
		costeo.setTrabajo(trabajo);
		costeo.setGastoFijo(0);
		costeo.setGastoVariable(0);
		costeo.setUsuario(user);
		
		Icosteo.save(costeo);
		
		idCosteo = Icosteo.findIdCosteoByTrabajoIdTrabajo(idTrabajo);
		
		System.out.println("Id costeo : " + idCosteo);
		session.setAttribute("IDCosteo", idCosteo);
	} else if (trabajos.getIdCosteo() != null) {
	    idCosteo = trabajos.getIdCosteo();
	}
	
	Integer id_costeo =  idCosteo !=null ? idCosteo : sessionIDCosteo;
	//GASTOFIJO-----COSTEO
	
	if(id_costeo !=null && !trabajos.getDescripcionFijo().isEmpty()) {
		
		CostoFijo cFijo = new CostoFijo();
		
		Optional<Costeo> costeo=Icosteo.findById(id_costeo);
		
		cFijo.setCosteo(costeo.get());
		cFijo.setDescripcion(trabajos.getDescripcionFijo());
		cFijo.setMonto(trabajos.getMontoFijo());
		
		System.out.println("Descripcion: " + cFijo.getDescripcion());
		icostoFijo.save(cFijo);
		
	}
	//COSTEO---MATERIAL
	if(id_costeo !=null && trabajos.getIdMaterial() !=null) {
        Costeo_Material cMaterial = new Costeo_Material();
		
		Optional<Costeo> costeo=Icosteo.findById(id_costeo);
		Costeo_MaterialCom id = new Costeo_MaterialCom(id_costeo,trabajos.getIdMaterial());; 
	
		cMaterial.setId(id);
		cMaterial.setCantidad(trabajos.getCantidadMaterial());
		cMaterial.setCostoTotal(trabajos.getCostoTotalMaterial());
		cMaterial.setCosteo(costeo.get());
		Material material = mater.findByIdMaterial(trabajos.getIdMaterial());
		cMaterial.setMaterial(material);
		
		icosteoMaterial.save(cMaterial);
	}
	//COSTEO----IMPLEMENTOS
	if(id_costeo !=null && trabajos.getIdImplemento() !=null) {
		Costeo_Implemento impSeg = new Costeo_Implemento();
		
		Optional<Costeo> costeo=Icosteo.findById(id_costeo);
		CosteoImplementocom id = new CosteoImplementocom(id_costeo,trabajos.getIdImplemento());
	
		impSeg.setId(id);
		impSeg.setCantidad(trabajos.getCantidadImplemento());
		impSeg.setCostoTotal(trabajos.getCostoTotalImplemento());
		impSeg.setCosteo(costeo.get());
		Implemento_Seguridad objSeguridad = impSeguridad.findByIdImplemento(trabajos.getIdImplemento());
		impSeg.setImplemento(objSeguridad);
		
		iImpRepository.save(impSeg);
		
		
	}
	
	//Costeo---SERVICIO
	if(id_costeo !=null && trabajos.getIdServicio() !=null) {
		Costeo_Servicio Cservicio = new Costeo_Servicio();
		
		Optional<Costeo> costeo=Icosteo.findById(id_costeo);
		Costeo_ServicioId id = new Costeo_ServicioId(id_costeo,trabajos.getIdServicio());
	
		Cservicio.setId(id);
		Cservicio.setCantidad(trabajos.getCantidadServicio());
		Cservicio.setCostoTotal(trabajos.getCostoTotalServicio());
		Cservicio.setCosteo(costeo.get());
		Servicio servicio = serv.findByIdServicio(trabajos.getIdServicio());
		Cservicio.setServicio(servicio);
		
		servicioRepository.save(Cservicio);
	}
	return "redirect:/trabajoCosteo/Costeo";
}

@GetMapping("/indicador/{IDCosteo}/{IDtrabajo}")
public String indicadorFinanciero(@PathVariable int IDCosteo, @PathVariable int IDtrabajo, HttpSession session) {
	indicadorservice.costoVariableTotal(IDCosteo);
	indicadorservice.costoFijoTotal(IDCosteo);
	
	double totalServicio = indicadorservice.costoTotalServicio(IDCosteo);
	
	double valorInterno = indicadorservice.valorInternoTrabajo(IDtrabajo);
	
	double cVarUnit = indicadorservice.costoVariableUnitario(IDCosteo);
	
	//GUARDAR EN BD
	double gananciainterno = indicadorservice.gananciaEsperada(valorInterno,totalServicio);
	double margen = Math.round(indicadorservice.margenGanancia(gananciainterno, valorInterno) * 10)/10;
	double equilibrio = Math.round(indicadorservice.puntoEquilibrio(IDCosteo, valorInterno, cVarUnit)*10)/10;
	double rentabilidad = Math.round(indicadorservice.rentabilidad(gananciainterno, totalServicio)*10)/10;
	
	System.out.println("COSTO TOTAL DE SERVICIO : " + totalServicio);
	System.out.println("VALOR INTERNO SERV : " + valorInterno);
	System.out.println("COSTO VAR UNITARIO : " + cVarUnit);
	System.out.println("GANANCIA ESPERADA : " + gananciainterno);
	System.out.println("MARGEN DE GANANCIA : " + margen);
	System.out.println("EQUILIBRIO : " + equilibrio);
	System.out.println("RENTABILIDAD : " + rentabilidad);
	
	IndicadorFinanciero indicador = new IndicadorFinanciero();
	Optional<Costeo> cos = Icosteo.findById(IDCosteo);
	if(cos.isPresent()) {
		indicador.setCosteo(cos.get());	
	}else {
	   throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error en ubicar el costeo");
	}
	indicador.setGananciaEsperada(gananciainterno);
	indicador.setMargenGanancia(margen);
	indicador.setPuntoEquilibrio(equilibrio);
	indicador.setRentabilidad(rentabilidad);
	
	indicadorRepository.save(indicador);
	
	return "redirect:/trabajoCosteo/Costeo";
}









//METODOS DE VISTA COSTEO(CALCULA TOTALES)

@GetMapping("/obtenerCostoMaterial")
@ResponseBody
public double obtenerCostoMaterial(Integer idMaterial,int cantidad) {
    return servicio.obtenerTotalCostoMateriales(idMaterial, cantidad);
}

@GetMapping("/obtenerCostoImplementos")
@ResponseBody
public double obtenerCostoImplementos(Integer idImplemento,int cantidad) {
    double costo = impService.obtenerCostosImplementos(idImplemento, cantidad);
    System.out.println("COSTO: "+costo);
    System.out.println("ID: "+idImplemento);
return costo;
}

}
