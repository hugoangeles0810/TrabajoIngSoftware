/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.ModeloBusDTO;
import com.informatica2012.sget.entity.ModeloBus;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface ModeloBusService extends BaseService<ModeloBus, Integer> {
    
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    public void guardarModeloBus(ModeloBusDTO modeloBusDTO) throws BusinessException;
    public ModeloBus obtenerPorNombre(String nombre);
    
}
