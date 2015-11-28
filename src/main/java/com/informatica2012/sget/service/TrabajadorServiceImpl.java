/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.TrabajadorDTO;
import com.informatica2012.sget.entity.Persona;
import com.informatica2012.sget.entity.Trabajador;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.TrabajadorRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Helper;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class TrabajadorServiceImpl extends BaseServiceImpl<Trabajador, Integer>
                implements TrabajadorService{
    
    @Autowired
    private TrabajadorRepository trabajadorRepository;
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private CargoService cargoService;
    
    @Autowired
    private EstacionTrabajoService estacionTrabajoService;
    
    @Autowired
    public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository) {
        super(trabajadorRepository);
    }
    
    @Override
    public void guardarTrabajador(TrabajadorDTO trabajadorDTO) throws BusinessException {
        if (esGuardarValido(trabajadorDTO)) {
            Persona persona = trabajadorDTO.getPersona();
            personaService.save(persona);
            Trabajador trabajador = fillTrabajador(persona, trabajadorDTO);
            trabajadorRepository.save(trabajador);
        }
    }
    
    @Override
    public void actualizarTrabajador(TrabajadorDTO trabajadorDTO) throws BusinessException {
        Trabajador trabajador = trabajadorRepository.get(trabajadorDTO.getId());
        Persona persona = personaService.get(trabajador.getPersona().getId());
        
        trabajadorDTO.passValuesForUpdate(persona);
        trabajador.setCargo(cargoService.get(trabajadorDTO.getCargo()));
        trabajador.setEstacionTrabajo(estacionTrabajoService.get(trabajadorDTO.getEstacion()));
        
        personaService.update(persona);
        trabajadorRepository.update(trabajador);        
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Trabajador.class);
        
        Long totalRows = trabajadorRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Trabajador> items = trabajadorRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
    private boolean esGuardarValido(TrabajadorDTO trabajadorDTO) throws BusinessException {
        
        if (personaService.buscarPorDni(trabajadorDTO.getDni()) != null) {
            throw new BusinessException("Ya existe una persona registrada con este DNI.");
        }
        
        return true;
    }
    
    private Trabajador fillTrabajador(Persona persona, TrabajadorDTO trabajadorDTO) {
        Trabajador trabajador = new Trabajador();
        trabajador.setPersona(persona);
        trabajador.setCargo(cargoService.get(trabajadorDTO.getCargo()));
        trabajador.setEstacionTrabajo(estacionTrabajoService.get(trabajadorDTO.getEstacion()));
        trabajador.setFechaingreso(Helper.parseDate(trabajadorDTO.getFechaIngreso()));
        return trabajador;
    }
    
}
