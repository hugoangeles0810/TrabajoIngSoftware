/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.repository;

import java.net.URL;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hugo
 */
@Repository
public class ReporteRepositoryImpl implements ReporteRepository{
    
    private static final String REPORTS_DIR = "/com/informatica2012/sget/report/";
    private static final String JASPER_SUFFIX = ".jasper";
    private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
    
    @Autowired
    private DataSource dataSource;

    @Override
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public JasperPrint generarReporte(String reportName, Map<String, Object> parameters) {
        JasperPrint jasperPrint = null;
        @SuppressWarnings("UnusedAssignment")
        JasperReport jasperReport = null;
        
        try {
            
            if (parameters == null) {
                parameters = new HashMap();
            }
            
            jasperReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource(REPORTS_DIR + reportName + JASPER_SUFFIX));
            parameters.put(SUBREPORT_DIR, getClass().getResource(REPORTS_DIR).toString());
            Connection connection = dataSource.getConnection();
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return jasperPrint;
    }
    
    
    
}
