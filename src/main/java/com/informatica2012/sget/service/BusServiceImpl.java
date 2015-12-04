/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.BusDTO;
import com.informatica2012.sget.entity.Bus;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.BusRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class BusServiceImpl extends BaseServiceImpl<Bus, Integer>
                implements BusService{

    @Autowired
    private BusRepository busRepository;
    
    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        super(busRepository);
    }
    
    @Override
    public Bus buscarPorPlaca(String placa) {
        Criterio criterio = Criterio.forClass(Bus.class);
        criterio.add(Restrictions.eq("placa", placa));
        
        List<Bus> buses = busRepository.searchForCriteria(criterio);
        
        if (buses != null && !buses.isEmpty()) {
            return buses.get(0);
        }
        
        return null;
    }
    
    @Override
    public void guardarBus(BusDTO busDTO) throws BusinessException {
        if (esGuardarValido(busDTO)) {
            Bus bus = busDTO.getBus();
            busRepository.save(bus);
        }
    }
    
    @Override
    public void actualizarBus(BusDTO busDTO) throws BusinessException {
        Bus bus = busRepository.get(busDTO.getId());
        busDTO.passValues(bus);
        busRepository.update(bus);
    }
    
    private boolean esGuardarValido(BusDTO busDTO) throws BusinessException {
        
        if (buscarPorPlaca(busDTO.getPlaca()) != null) {
           throw new BusinessException("Ya existe un busr registrado con está placa.");
        }
        
        return true;
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Bus.class);
        criterio.add(Restrictions.ilike("placa", search, MatchMode.ANYWHERE));
        Long totalRows = busRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Bus> items = busRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
}
