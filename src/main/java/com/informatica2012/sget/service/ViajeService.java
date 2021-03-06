/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.ViajeDTO;
import com.informatica2012.sget.entity.Viaje;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface ViajeService extends BaseService<Viaje, Integer> {
    
    public void guardarViaje(ViajeDTO viajeDTO) throws BusinessException;
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    
}
