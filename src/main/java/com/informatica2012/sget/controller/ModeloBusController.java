/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.ModeloBusDTO;
import com.informatica2012.sget.entity.ModeloBus;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.service.ModeloBusService;
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
@RequestMapping("/mantenimiento/modelobus")
public class ModeloBusController {
    
    public static final String PREFIX = "mantenimiento/modelobus/";
    
    @Autowired
    private ModeloBusService modeloBusService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        Paginacion paginacion = modeloBusService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public ModeloBusDTO obtener(@PathVariable("id") Integer id) {
        return new ModeloBusDTO(modeloBusService.get(id));
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody ModeloBusDTO modeloBusDTO){
        
        try {

            modeloBusService.guardarModeloBus(modeloBusDTO);
            
            return Helper.responseMapSuccess("Modelo de bus registrado.");
        } catch (BusinessException e) {
            return Helper.responseMapError(e.getMessage());
        }
    }
    
    @RequestMapping(value = "/actualizar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> actualizar(@RequestBody ModeloBusDTO modeloBusDTO){
        
        try {
            
            modeloBusService.update(modeloBusDTO.getModeloBus());
            
            return Helper.responseMapSuccess("Modelo de bus actualizado.");
        } catch (Exception e) {
            e.printStackTrace();
            return Helper.responseMapError("Error al actualizar el modelo de bus");
        }
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            ModeloBus m = modeloBusService.get(id);
            if (m != null) {
                modeloBusService.delete(m);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
    
    @RequestMapping(value = "/buscador.html", method = RequestMethod.GET)
    public ModelAndView buscadorModeloBus(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "tableModelos");
        Paginacion paginacion = modeloBusService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
}
