/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.CargoDTO;
import com.informatica2012.sget.entity.Cargo;
import com.informatica2012.sget.service.CargoService;
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
@RequestMapping("/mantenimiento/cargo")
public class CargoController {
    
    public static final String PREFIX = "mantenimiento/cargo/";
    
    @Autowired
    private CargoService cargoService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        Paginacion paginacion = cargoService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
    @RequestMapping(value = "/obtener/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public CargoDTO obtener(@PathVariable("id") Integer id) {
        return new CargoDTO(cargoService.get(id));
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody Cargo cargo){
        
        Map<String, Object> map = new HashMap();
        try {
            if (cargo.getId() != null) {
                cargoService.update(cargo);
            } else {
                cargoService.save(cargo);
            }
            
            map.put("status", "success");
        } catch (Exception e) {
            map.put("status", "error");
            map.put("msg", "Error al registrar el lugar");
        }
        
        return map;
    }
    
    @RequestMapping(value = "/borrar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> borrar(@RequestParam("id") Integer id){
        Map<String, Object> map = new HashMap();
        
        try {
            Cargo c = cargoService.get(id);
            if (c != null) {
                cargoService.delete(c);
            }
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
        }
        
        return map;
    }
    
    @RequestMapping(value = "/buscador.html", method = RequestMethod.GET)
    public ModelAndView buscadorLugar(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "tableCargos");
        Paginacion paginacion = cargoService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
}
