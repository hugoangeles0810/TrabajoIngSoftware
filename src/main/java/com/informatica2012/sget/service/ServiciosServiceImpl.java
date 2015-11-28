/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Servicios;
import com.informatica2012.sget.repository.ServiciosRepository;
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
public class ServiciosServiceImpl extends BaseServiceImpl<Servicios, Integer>
        implements ServiciosService {

    @Autowired
    private ServiciosRepository serviciosRepository;

    @Autowired
    public ServiciosServiceImpl(ServiciosRepository serviciosRepository) {
        super(serviciosRepository);
    }

    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Servicios.class);
        criterio.add(Restrictions.ilike("nombre", search, MatchMode.ANYWHERE));
        Long totalRows = serviciosRepository.countResultForCriteria(criterio);

        criterio.setFirstResult(size * (page - 1));
        criterio.setMaxResults(size);

        List<Servicios> items = serviciosRepository.searchForCriteria(criterio);

        return Paginacion.build(page, size, search, totalRows, items);
    }

}
