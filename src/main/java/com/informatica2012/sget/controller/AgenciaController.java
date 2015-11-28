/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.AgenciaDTO;
import com.informatica2012.sget.entity.Agencia;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.service.AgenciaService;
import com.informatica2012.sget.util.Helper;
import com.informatica2012.sget.util.Paginacion;
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
@RequestMapping("/mantenimiento/agencia")
public class AgenciaController {
    
    public static final String PREFIX = "mantenimiento/agencia/";
    
    @Autowired
    private AgenciaService agenciaService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        Paginacion paginacion = agenciaService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public AgenciaDTO obtener(@PathVariable("id") Integer id) {
        return new AgenciaDTO(agenciaService.get(id));
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody AgenciaDTO agencia){
        try {
            agenciaService.guardarAgencia(agencia);
            return Helper.responseMapSuccess("Agencia registrada con éxito.");
        } catch (BusinessException e) {
            return Helper.responseMapError(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/actualizar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> actualizar(@RequestBody AgenciaDTO agencia){
        try {
            agenciaService.actualizarAgencia(agencia);
            return Helper.responseMapSuccess("Agencia actualizada con éxito.");
        } catch (BusinessException e) {
            return Helper.responseMapError(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            Agencia a = agenciaService.get(id);
            if (a != null) {
                agenciaService.delete(a);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
    
}
