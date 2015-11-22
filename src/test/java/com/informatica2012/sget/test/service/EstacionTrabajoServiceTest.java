/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.test.service;

import com.informatica2012.sget.entity.EstacionTrabajo;
import com.informatica2012.sget.entity.Lugar;
import com.informatica2012.sget.service.EstacionTrabajoService;
import com.informatica2012.sget.service.LugarService;
import com.informatica2012.sget.test.AbstractTestSuite;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class EstacionTrabajoServiceTest extends AbstractTestSuite{
    
    @Autowired
    private EstacionTrabajoService estacionTrabajoService;
    
    @Autowired
    private LugarService lugarService;
    
    private Lugar lugar;

    @Override
    public void setUp() throws Exception {
        lugar = lugarService.getAll().get(0);
    }
    
    @Test
    public void crearEstacionTest() throws Exception {
        System.out.println("--------------------------");
        EstacionTrabajo estacionTrabajo = new EstacionTrabajo();
        estacionTrabajo.setLugar(lugar);
        estacionTrabajo.setNombre("Estacion 1");
        estacionTrabajo.setDireccion("Calle test");
        
        estacionTrabajoService.save(estacionTrabajo);
        
        assertNotNull(estacionTrabajo.getId());
        System.out.println(estacionTrabajo);
        System.out.println("--------------------------");
        
    }
    
    
    
}
