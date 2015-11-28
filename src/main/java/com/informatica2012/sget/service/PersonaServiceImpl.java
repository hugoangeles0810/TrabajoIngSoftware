/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Persona;
import com.informatica2012.sget.repository.PersonaRepository;
import com.informatica2012.sget.util.Criterio;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Integer>
                implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;
    
    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        super(personaRepository);
    }
    
    @Override
    public Persona buscarPorDni(String dni) {
        Criterio criterio = Criterio.forClass(Persona.class);
        criterio.add(Restrictions.eq("dni", dni));
        
        List<Persona> personas = personaRepository.searchForCriteria(criterio);
        if (personas != null && !personas.isEmpty()) {
            return personas.get(0);
        }
        
        return null;
    }
    
}
