/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.report.ReporteFormato;
import com.informatica2012.sget.repository.ReporteRepository;
import com.informatica2012.sget.util.JasperExport;
import java.util.Map;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class ReporteServiceImpl implements ReporteService {
    
    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public byte[] generarReporte(String reportName, ReporteFormato formatType, Map<String, Object> parameters) {
        @SuppressWarnings("UnusedAssignment")
        byte[] response = null;
        
        JasperPrint jasperPrint = reporteRepository.generarReporte(reportName, parameters);
        
        switch (formatType) {
            case PDF:
                response = JasperExport.pdfReportToArray(jasperPrint);
                break;
            case WORD:
                response = JasperExport.rtfReportToArray(jasperPrint);
                break;
            case EXCEL:
                response = JasperExport.xlsReportToArray(jasperPrint);
                break;
            default:
                response = JasperExport.pdfReportToArray(jasperPrint);
                break;
        }
        
        return response;
    }

    @Override
    public byte[] generarReportePDF(String reportName, Map<String, Object> parameters) {
        return generarReporte(reportName, ReporteFormato.PDF, parameters);
    }
    
}
