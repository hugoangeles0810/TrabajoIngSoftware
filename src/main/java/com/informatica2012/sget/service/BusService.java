/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.BusDTO;
import com.informatica2012.sget.entity.Bus;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface BusService extends BaseService<Bus, Integer> {
    
    public Bus buscarPorPlaca(String placa);
    public void guardarBus(BusDTO busDTO) throws BusinessException;
    public void actualizarBus(BusDTO busDTO) throws BusinessException;
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    
}
