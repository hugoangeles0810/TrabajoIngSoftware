/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Persona;

/**
 *
 * @author Hugo
 */
public interface PersonaService extends BaseService<Persona, Integer>{
    
    public Persona buscarPorDni(String dni);
    
}
