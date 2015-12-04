/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.report.ReporteFormato;
import com.informatica2012.sget.report.Reportes;
import com.informatica2012.sget.service.ReporteService;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
}
