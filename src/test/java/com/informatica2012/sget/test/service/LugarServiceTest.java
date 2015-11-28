/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.test.service;

import com.informatica2012.sget.entity.Lugar;
import com.informatica2012.sget.service.LugarService;
import com.informatica2012.sget.test.AbstractTestSuite;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class LugarServiceTest extends AbstractTestSuite{
    
    @Autowired
    private LugarService lugarService;
    
    @Test
    public void createLugarTest() throws Exception {
        System.out.println("--------------------------");
        Lugar lugar = new Lugar();
        lugar.setPais("Peru");
        lugar.setEstado("Piura");
        lugar.setCiudad("Piura");
        lugar.setDistrito("Piura");
        
        lugarService.save(lugar);
            
        assertNotNull(lugar.getId());
        System.out.println("Lugar agregado: " + lugar);
        
        String pais = "Siria";
        lugar.setPais(pais);
        lugarService.update(lugar);
        
        Lugar flag = lugarService.get(lugar.getId());
        
        assertNotNull("Debe obtener una entidad dado su Id", flag);
        assertEquals(flag.getPais(), pais);
        System.out.println("--------------------------");
    }
    
}
