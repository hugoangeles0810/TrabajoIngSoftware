/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Rol;
import com.informatica2012.sget.repository.RolRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author CARLOS
 */
@Service
public class RolServiceImpl extends BaseServiceImpl<Rol, Integer> implements
        RolService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        super(rolRepository);
    }

    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Rol.class);
        criterio.add(Restrictions.ilike("nombre", search, MatchMode.ANYWHERE));
        Long totalRows = rolRepository.countResultForCriteria(criterio);

        criterio.setFirstResult(size * (page - 1));
        criterio.setMaxResults(size);

        List<Rol> items = rolRepository.searchForCriteria(criterio);

        return Paginacion.build(page, size, search, totalRows, items);
    }

}
