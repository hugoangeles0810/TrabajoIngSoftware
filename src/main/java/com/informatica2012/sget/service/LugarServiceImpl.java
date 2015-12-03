/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Lugar;
import com.informatica2012.sget.repository.LugarRepository;
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
public class LugarServiceImpl extends BaseServiceImpl<Lugar, Integer>
                implements LugarService{
    
    @Autowired
    private LugarRepository lugarRepository;

    @Autowired
    public LugarServiceImpl(LugarRepository lugarRpository) {
        super(lugarRpository);
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Lugar.class);
        
        Long totalRows = lugarRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Lugar> items = lugarRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
}
