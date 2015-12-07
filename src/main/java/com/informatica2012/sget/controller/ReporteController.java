/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.report.Reportes;
import com.informatica2012.sget.service.ReporteService;
import com.informatica2012.sget.util.Helper;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hugo
 */
@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    private static final String PREFIX = "reportes/";
    
    @Autowired
    private ReporteService reporteService;
 
    @RequestMapping(value = "/reportedebuses.html", method = RequestMethod.GET)
    public void reporteDeBuses(HttpServletRequest request, HttpServletResponse response) {
        Date now = new Date();
        response.setContentType("application/pdf");
        try {
            
            ServletOutputStream out = response.getOutputStream();
            byte[] bytes = reporteService.generarReportePDF(Reportes.REPORTE_BUSES, null);
            System.out.println(bytes);
            out.write(bytes, 0, bytes.length);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    @RequestMapping(value = "/formreporteviajesprogramados.html", method = RequestMethod.GET)
    public String formReporteDeViajes() {
        return PREFIX + "formreportedeviajes";
    }
    
    @RequestMapping(value = "/reporteviajesprogramados.html", method = RequestMethod.GET)
    public void reporteDeViajesProgramados(HttpServletRequest request, HttpServletResponse response) {
        Date now = new Date();
        response.setContentType("application/pdf");
        try {
            
            Map<String, Object> map = new HashMap();
            
             map.put("desde", Helper.parseDate(request.getParameter("desde")));
             map.put("hasta", Helper.parseDate(request.getParameter("hasta")));
            
            ServletOutputStream out = response.getOutputStream();
            byte[] bytes = reporteService.generarReportePDF(Reportes.REPORTE_VIAJES_PROGRAMADOS, map);
            System.out.println(bytes);
            out.write(bytes, 0, bytes.length);
            out.flush();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
}
