/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.TrabajadorDTO;
import com.informatica2012.sget.entity.Trabajador;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface TrabajadorService extends BaseService<Trabajador, Integer>{
    
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    public void guardarTrabajador(TrabajadorDTO trabajadorDTO) throws BusinessException;
    public void actualizarTrabajador(TrabajadorDTO trabajadorDTO) throws BusinessException;
    public void eliminarTrabajador(Integer id);
    
}
