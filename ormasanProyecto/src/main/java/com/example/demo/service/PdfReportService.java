package com.example.demo.service;

import com.example.demo.DTO.ReporteViewDTO;
import com.example.demo.DTO.TrabajoDTO;
import com.example.demo.models.view.VistaReporteCosteo;
import com.example.demo.repositoryView.VistaReporteCosteoRepository;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfReportService {

    @Autowired
    private VistaReporteCosteoRepository repository;

    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * Recupera registros filtrados por idZona y rango de fechas.
     * Agrega logs para depuración.
     */
    public List<VistaReporteCosteo> fetchReportesPorZonaYFechas(
            Long idZona, String fechaInicio, String fechaFin) {

        LocalDate desde = LocalDate.parse(fechaInicio, FMT);
        LocalDate hasta = LocalDate.parse(fechaFin,    FMT);

        System.out.println("[DEBUG] fetchReportesPorZonaYFechas -> idZona=" + idZona
            + ", desde=" + desde + ", hasta=" + hasta);

        List<VistaReporteCosteo> lista = repository.findByIdZonaAndFechaBetween(idZona, desde, hasta);

        System.out.println("[DEBUG] Resultados encontrados: " + lista.size());

        return lista;
    }

    /**
     * Genera un PDF a partir de la lista proporcionada.
     * También registra la cantidad de registros.
     */
    public byte[] generatePdfBytes(ReporteViewDTO reporte,List<TrabajoDTO> listaTrabajoDTO) throws IOException {
        System.out.println("[DEBUG] Generando PDF para " + listaTrabajoDTO.size() + " registros.");
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Document doc = new Document();
            PdfWriter.getInstance(doc, out);
            doc.open();

            doc.add(new Paragraph("*** REPORTE DE COSTEO DE " + reporte.getZonaTrabajo() + "***"));
            doc.add(new Paragraph("Total de registros: " + listaTrabajoDTO.size()));
            doc.add(new Paragraph(" "));

            for (TrabajoDTO ltDTO : listaTrabajoDTO) {
                doc.add(new Paragraph(
                    String.format("Nombre Trabajo: %s | Fecha: %s",
                    		ltDTO.getNombre(),ltDTO.getFecha()
                        
                    )
                ));
            }
            
            doc.add(new Paragraph("--------------------------------------------------"));
            doc.add(new Paragraph("***EFICIENCIA***"));
            doc.add(new Paragraph(
                    String.format("Fijo: %.2f | Variable: %.2f | Total: %.2f | Ganancia: %.2f | Margen: %.2f | Rentabilida: %.2f",
                    		reporte.getCostoFijo(),reporte.getCostoVariable(),
                    		reporte.getCostoTotal(), reporte.getGananciaObtenida(),
                    		reporte.getMargenGanancia(),reporte.getRentabilidad()
                    )
                ));

            doc.close();
            
            
            return out.toByteArray();

        } catch (DocumentException e) {
            throw new IOException("Error al generar el PDF", e);
        }
    }
}
