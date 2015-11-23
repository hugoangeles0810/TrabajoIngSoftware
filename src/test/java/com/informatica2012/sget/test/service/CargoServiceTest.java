/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.test.service;

import com.informatica2012.sget.entity.Cargo;
import com.informatica2012.sget.service.CargoService;
import com.informatica2012.sget.test.AbstractTestSuite;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;

/**
 *
 * @author Hugo
 */
public class CargoServiceTest extends AbstractTestSuite{
    
    @Autowired
    private CargoService cargoService;
    
    @Test
    public void addCargoTest() throws Exception {
        System.out.println("--------------------------");
        Cargo cargo = new Cargo();
        cargo.setNombre("Gerente");
        
        cargoService.save(cargo);
        
        assertNotNull(cargo.getId());
        System.out.println(cargo);
        System.out.println("--------------------------");
    }
    
}
