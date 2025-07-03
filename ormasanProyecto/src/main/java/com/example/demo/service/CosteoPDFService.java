package com.example.demo.service;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Costeo;
import com.example.demo.models.IndicadorFinanciero;
import com.example.demo.models.view.Vista_costeo_gastos_fijos;
import com.example.demo.models.view.Vista_costeo_implementos;
import com.example.demo.models.view.Vista_costeo_materiales;
import com.example.demo.models.view.Vista_costeo_servicios;
import com.example.demo.repository.IindicadorFinancieroRepository;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;

import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;

import com.lowagie.text.pdf.PdfPTable;

import com.lowagie.text.pdf.PdfWriter;



@Service
public class CosteoPDFService {
@Autowired
IindicadorFinancieroRepository indicador;
	public void exportarPDF(List<Vista_costeo_implementos> imp,List<Vista_costeo_materiales> mat,List<Vista_costeo_servicios> serv,List<Vista_costeo_gastos_fijos> fijo,Costeo cos,OutputStream salida){
		try {
            Document doc = new Document(PageSize.A4);
            PdfWriter.getInstance(doc, salida);
            doc.open();

            // Título general
            Paragraph titulo = new Paragraph("Costeo completo", 
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, Color.DARK_GRAY));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);
            doc.add(Chunk.NEWLINE);

            // Tabla de Trabajo
            Paragraph seccion1 = new Paragraph("Detalle Trabajo", 
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.BLUE));
            doc.add(seccion1);
            doc.add(Chunk.NEWLINE);

            PdfPTable tablaTrabajo = new PdfPTable(8);
            tablaTrabajo.setWidthPercentage(100);
            tablaTrabajo.setSpacingBefore(5);
            tablaTrabajo.addCell("ID");
            tablaTrabajo.addCell("ZONA");
            tablaTrabajo.addCell("EQUIPO");
            tablaTrabajo.addCell("TRABAJO");
            tablaTrabajo.addCell("FECHA");
            tablaTrabajo.addCell("UNIDAD DE MEDIDA");
            tablaTrabajo.addCell("CANTIDAD TRABAJADA");
            tablaTrabajo.addCell("DIAS");
         
            Vista_costeo_gastos_fijos f = fijo.get(0);
           
            	tablaTrabajo.addCell(String.valueOf(f.getIdTrabajo()));
            	tablaTrabajo.addCell(f.getNombreZona());
            	tablaTrabajo.addCell(f.getNombreEquipo());
            	tablaTrabajo.addCell(f.getNombreTrabajo());
            	tablaTrabajo.addCell(String.valueOf(f.getFechaTrabajo()));
            	tablaTrabajo.addCell(f.getUnidadMedida());
            	tablaTrabajo.addCell(String.valueOf(f.getCantidadTrabajada()));
            	tablaTrabajo.addCell(String.valueOf(f.getDiasTrabajados()));
            	
            
            doc.add(tablaTrabajo);
            doc.add(Chunk.NEWLINE);

            // Tabla de Gastos fijos
            Paragraph seccion2 = new Paragraph("Gastos Fijos", 
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.ORANGE));
            doc.add(seccion2);
            doc.add(Chunk.NEWLINE);

            PdfPTable tablaFijos = new PdfPTable(2);
            tablaFijos.setWidthPercentage(100);
            tablaFijos.setSpacingBefore(5);
            tablaFijos.addCell("DESCRIPCIÓN");
            tablaFijos.addCell("MONTO");          

            for (Vista_costeo_gastos_fijos gf : fijo) {
            	tablaFijos.addCell(gf.getDescripcionGastoFijo());
            	tablaFijos.addCell(String.valueOf(gf.getMontoGastoFijo()));
            	
            }
            tablaFijos.addCell("     TOTAL: ");
            tablaFijos.addCell(String.valueOf(cos.getGastoFijo()));
            doc.add(tablaFijos);

            //Tabla gastos variables
            Paragraph seccion3 = new Paragraph("Gastos Variables", 
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.MAGENTA));
            doc.add(seccion3);
            doc.add(Chunk.NEWLINE);

            PdfPTable tablaVariables = new PdfPTable(4);
            tablaVariables.setWidthPercentage(100);
            tablaVariables.setSpacingBefore(5);
            tablaVariables.addCell("TIPOGASTO");
            tablaVariables.addCell("DESCRIPCIÓN");
            tablaVariables.addCell("CANTIDAD");
            tablaVariables.addCell("TOTAL");

            for (Vista_costeo_materiales m : mat) {
            	tablaVariables.addCell("Material");
            	tablaVariables.addCell(m.getNombreMaterial());
            	tablaVariables.addCell(String.valueOf(m.getCantidad()));
            	tablaVariables.addCell(String.valueOf(m.getCostoTotal()));
            	
            }
            
            for (Vista_costeo_implementos im : imp) {
            	tablaVariables.addCell("Implementos de seguridad");
            	tablaVariables.addCell(im.getNombreImplemento());
            	tablaVariables.addCell(String.valueOf(im.getCantidadImplemento()));
            	tablaVariables.addCell(String.valueOf(im.getCostoImplementoTotal()));
            	
            }
            
            if(!serv.isEmpty()) {
                for (Vista_costeo_servicios sv : serv) {
                	tablaVariables.addCell("Servicio externo");
                	tablaVariables.addCell(sv.getNombreServicio());
                	tablaVariables.addCell(String.valueOf(sv.getCantidadServicio()));
                	tablaVariables.addCell(String.valueOf(sv.getCostoServicioTotal()));
                	
                }
            }
            tablaVariables.addCell(" ");
            tablaVariables.addCell(" ");
            tablaVariables.addCell("     SUBTOTAL: ");
            tablaVariables.addCell(String.valueOf(cos.getGastoVariable()));
            doc.add(tablaVariables);
            
            Paragraph seccion4 = new Paragraph("Indicador Financiero", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Color.BLUE));
                doc.add(seccion4);
                doc.add(Chunk.NEWLINE);
            PdfPTable tablaIndicador = new PdfPTable(5);
            tablaIndicador.setWidthPercentage(100);
            tablaIndicador.setSpacingBefore(5);
            tablaIndicador.addCell("COSTO TOTAL SERVICIO");
            tablaIndicador.addCell("GANANCIA ESPERADA");
            tablaIndicador.addCell("MARGEN DE GANANCIA");
            tablaIndicador.addCell("PUNTO EQUILIBRIO");
            tablaIndicador.addCell("RENTABILIDAD");
         
            Optional<IndicadorFinanciero> indF = indicador.findByCosteoIdCosteo(cos.getIdCosteo());
           
            tablaIndicador.addCell(String.valueOf(cos.getTotal()));
            tablaIndicador.addCell(String.valueOf(indF.get().getGananciaEsperada()));
            tablaIndicador.addCell(String.valueOf(indF.get().getMargenGanancia()));
            tablaIndicador.addCell(String.valueOf(indF.get().getPuntoEquilibrio()));
            tablaIndicador.addCell(String.valueOf(indF.get().getRentabilidad()));
            
            	
            doc.add(tablaIndicador);
            
            doc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		

}
