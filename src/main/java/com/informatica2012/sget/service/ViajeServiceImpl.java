/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.ViajeDTO;
import com.informatica2012.sget.entity.Viaje;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.ViajeRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Paginacion;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class ViajeServiceImpl extends BaseServiceImpl<Viaje, Integer> 
                implements ViajeService{

    @Autowired
    private ViajeRepository viajeRepository;
    
    @Autowired
    public ViajeServiceImpl(ViajeRepository viajeRepository) {
        super(viajeRepository);
    }
    
    @Override
    public void guardarViaje(ViajeDTO viajeDTO) throws BusinessException{
        if (esGuardarValido(viajeDTO)) {
            Viaje viaje = viajeDTO.getViaje();
            viajeRepository.save(viaje);
        }
    }
    
    
    public boolean esGuardarValido(ViajeDTO viajeDTO) throws BusinessException {
        
        Date now = new Date();
        Viaje viaje = viajeDTO.getViaje();
        
        if (viaje.getOrigen().getId().equals(viaje.getDestino().getId())) {
            throw new BusinessException("La agencia de origen no puede ser igual a la agencia de destino.");
        }
        
        if (now.compareTo(viaje.getPartida()) > 0) {
            throw new BusinessException("Fecha de programación incorrecta");
        }
        
        return true;
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Date now = new Date();
        Criterio criterio = Criterio.forClass(Viaje.class);
        criterio.add(Restrictions.ge("partida", now));
        
        Long totalRows = viajeRepository.countResultForCriteria(criterio);
        
        criterio.addOrder(Order.asc("partida"));
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Viaje> items = viajeRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
}
