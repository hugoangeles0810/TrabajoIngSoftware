/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.entity.Lugar;
import com.informatica2012.sget.service.LugarService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hugo
 */
@Controller
@RequestMapping("/mantenimiento/lugar")
public class LugarController {
    
    public static final String PREFIX = "/mantenimiento/lugar";
    
    @Autowired
    private LugarService lugarService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("mantenimiento/lugar/index");
        mv.addObject("lugares", lugarService.getAll());
        return mv;
    }
    
    @RequestMapping(value = "/guardar.html", method = RequestMethod.POST)
    public String guardar(@RequestParam("pais") String pais,
                          @RequestParam("estado") String estado,
                          @RequestParam("ciudad") String ciudad,
                          @RequestParam("distrito") String distrito){
        
        Lugar lugar = new Lugar();
        lugar.setPais(pais);
        lugar.setEstado(estado);
        lugar.setCiudad(ciudad);
        lugar.setDistrito(distrito);
        
        lugarService.save(lugar);
        
        return "redirect:" + PREFIX + "/index.html";
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            Lugar l = lugarService.get(id);
            if (l != null) {
                lugarService.delete(l);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
  
}
