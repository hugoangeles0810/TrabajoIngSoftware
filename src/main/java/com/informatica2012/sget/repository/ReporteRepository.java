/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.repository;

import java.util.Map;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Hugo
 */
public interface ReporteRepository {
    
    public JasperPrint generarReporte(String reportName, Map<String, Object> parameters);
    
}
