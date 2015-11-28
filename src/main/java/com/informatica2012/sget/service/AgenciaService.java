/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.AgenciaDTO;
import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface AgenciaService extends BaseService<Agencia, Integer>{
    
    public void guardarAgencia(AgenciaDTO agenciaDTO) throws BusinessException;
    public void actualizarAgencia(AgenciaDTO agenciaDTO) throws BusinessException;
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    public Agencia buscarPorEstacionId(Integer estacionId);
    
}
