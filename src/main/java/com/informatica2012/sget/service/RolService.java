/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Rol;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author CARLOS
 */
public interface RolService extends BaseService<Rol, Integer> {

    public Paginacion getPaginationList(Integer page, Integer size, String search);
}
