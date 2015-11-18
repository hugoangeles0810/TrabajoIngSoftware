/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.entity.Lugar;
import com.informatica2012.sget.repository.LugarRepository;
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
    public LugarServiceImpl(LugarRepository lugarRpository) {
        super(lugarRpository);
    }
}
