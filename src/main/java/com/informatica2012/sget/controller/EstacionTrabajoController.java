/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.EstacionTrabajoDTO;
import com.informatica2012.sget.entity.EstacionTrabajo;
import com.informatica2012.sget.service.EstacionTrabajoService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/mantenimiento/estaciontrabajo")
public class EstacionTrabajoController {
    
    public static final String PREFIX = "mantenimiento/estaciontrabajo/";
    
    @Autowired
    private EstacionTrabajoService estacionTrabajoService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        mv.addObject("paginacion", estacionTrabajoService.getPaginationList(page, size, search));
        return mv;
    }
    
    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public EstacionTrabajoDTO obtener(@PathVariable("id") Integer id) {
        return new EstacionTrabajoDTO(estacionTrabajoService.get(id));
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody EstacionTrabajo estacion){
        System.out.println("estacion: " + estacion.getId());
        Map<String, Object> map = new HashMap();
        try {
            if (estacion.getId() != null) {
                estacionTrabajoService.update(estacion);
            } else {
                estacionTrabajoService.save(estacion);
            }
            
            map.put("status", "success");
        } catch (Exception e) {
            map.put("status", "error");
            map.put("msg", "Error al registrar la estación");
        }
        
        return map;
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            EstacionTrabajo estacion = estacionTrabajoService.get(id);
            if (estacion != null) {
                estacionTrabajoService.delete(estacion);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
    
}
