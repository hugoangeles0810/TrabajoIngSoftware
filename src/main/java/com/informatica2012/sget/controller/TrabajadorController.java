/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.TrabajadorDTO;
import com.informatica2012.sget.entity.Trabajador;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.service.TrabajadorService;
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
@RequestMapping("/mantenimiento/trabajador")
public class TrabajadorController {
    
    public static final String PREFIX = "mantenimiento/trabajador/";
    
    @Autowired
    private TrabajadorService trabajadorService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        Paginacion paginacion = trabajadorService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public TrabajadorDTO obtener(@PathVariable("id") Integer id) {
        return new TrabajadorDTO(trabajadorService.get(id));
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody TrabajadorDTO trabajadorDTO){
        try {
           trabajadorService.guardarTrabajador(trabajadorDTO);
           return Helper.responseMapSuccess("Trabajador registrado con éxito");
        } catch (BusinessException e) {
            return Helper.responseMapError(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/actualizar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> actualizar(@RequestBody TrabajadorDTO trabajadorDTO){
        try {
           trabajadorService.actualizarTrabajador(trabajadorDTO);
           return Helper.responseMapSuccess("Trabajador actualizado con éxito");
        } catch (BusinessException e) {
            return Helper.responseMapError(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            Trabajador trabajador = trabajadorService.get(id);
            if (trabajador != null) {
                trabajadorService.delete(trabajador);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
    
}
