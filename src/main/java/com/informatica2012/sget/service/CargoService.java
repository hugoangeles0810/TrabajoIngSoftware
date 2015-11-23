/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Cargo;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface CargoService extends BaseService<Cargo, Integer> {
    
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    
}
