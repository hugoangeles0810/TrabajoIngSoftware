/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.ModeloBusDTO;
import com.informatica2012.sget.entity.ModeloBus;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.ModeloBusRepository;
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
public class ModeloBusServiceImpl extends BaseServiceImpl<ModeloBus, Integer>
                implements ModeloBusService{
    
    @Autowired
    private ModeloBusRepository modeloBusRepository;

    @Autowired
    public ModeloBusServiceImpl(ModeloBusRepository modeloBusRepository) {
        super(modeloBusRepository);
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(ModeloBus.class);
        
        Long totalRows = modeloBusRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<ModeloBus> items = modeloBusRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
    @Override
    public ModeloBus obtenerPorNombre(String nombre) {
        Criterio criterio = Criterio.forClass(ModeloBus.class);
        criterio.add(Restrictions.eq("nombre", nombre));
                
        List<ModeloBus> modeloBuses = modeloBusRepository.searchForCriteria(criterio);
        
        if (modeloBuses != null && !modeloBuses.isEmpty()) {
            return modeloBuses.get(0);
        }
        
        return null;
    }
    
    @Override
    public void guardarModeloBus(ModeloBusDTO modeloBusDTO) throws BusinessException {
        if (esGuardarValido(modeloBusDTO)) {
            ModeloBus modelo = modeloBusDTO.getModeloBus();
            modeloBusRepository.save(modelo);
        }
    }
    
    private boolean esGuardarValido(ModeloBusDTO modeloBusDTO) throws BusinessException {
        
        if (obtenerPorNombre(modeloBusDTO.getNombre()) != null) {
            throw new BusinessException("Ya existe un modelo con este nombre.");
        }
        
        return true;
    }
    
}
