/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.EstacionTrabajo;
import com.informatica2012.sget.repository.EstacionTrabajoRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class EstacionTrabajoServiceImpl extends BaseServiceImpl<EstacionTrabajo, Integer>
                    implements EstacionTrabajoService{
    
    @Autowired
    private EstacionTrabajoRepository estacionTrabajoRepository;

    @Autowired
    public EstacionTrabajoServiceImpl(EstacionTrabajoRepository estacionTrabajoRepository) {
        super(estacionTrabajoRepository);
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(EstacionTrabajo.class);
        
        Long totalRows = estacionTrabajoRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<EstacionTrabajo> items = estacionTrabajoRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
    }
    
    
}
