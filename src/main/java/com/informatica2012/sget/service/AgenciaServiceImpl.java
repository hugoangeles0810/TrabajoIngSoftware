/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.AgenciaDTO;
import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.AgenciaRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class AgenciaServiceImpl extends BaseServiceImpl<Agencia, Integer>
                implements AgenciaService{

    @Autowired
    private AgenciaRepository agenciaRepository;
    
    @Autowired
    private EstacionTrabajoService estacionTrabajoService;
   
   @Autowired
    public AgenciaServiceImpl(AgenciaRepository agenciaRepository) {
        super(agenciaRepository);
    }
    
    @Override
    public void guardarAgencia(AgenciaDTO agenciaDTO) throws BusinessException {
        if (esGuardarValido(agenciaDTO)) {
            Agencia agencia = agenciaDTO.getAgencia();
            agenciaRepository.save(agencia);
        }
    }
    
    @Override
    public void actualizarAgencia(AgenciaDTO agenciaDTO) throws BusinessException {
        Agencia agencia = agenciaRepository.get(agenciaDTO.getId());
        agenciaDTO.passValues(agencia);
        agenciaRepository.update(agencia);
    }
    
    private boolean esGuardarValido(AgenciaDTO agenciaDTO) throws BusinessException{
        if (buscarPorEstacionId(agenciaDTO.getEstacion()) != null) {
            throw new BusinessException("Ya existe una Agencia perteneciente a esa estación");
        }
        
        return true;
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Agencia.class);
        
        Long totalRows = agenciaRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Agencia> items = agenciaRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
    @Override
    public Agencia buscarPorEstacionId(Integer estacionId) {
        Criterio criterio = Criterio.forClass(Agencia.class);
        criterio.createCriteria("estacionTrabajo")
                .add(Restrictions.eq("id", estacionId));
        
        List<Agencia> agencias = agenciaRepository.searchForCriteria(criterio);
        
        if (agencias != null && !agencias.isEmpty()) {
            return agencias.get(0);
        }
        
        return null;
    }
    
}
