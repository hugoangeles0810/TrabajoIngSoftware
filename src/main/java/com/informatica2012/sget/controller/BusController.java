/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import com.informatica2012.sget.dto.BusDTO;
import com.informatica2012.sget.service.BusService;
import com.informatica2012.sget.util.Helper;
import com.informatica2012.sget.util.Paginacion;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/mantenimiento/bus")
public class BusController {
    
    public static final String PREFIX = "mantenimiento/bus/";
    
    @Autowired
    private BusService busService;
    
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(
                    @RequestParam(value = "page", defaultValue = "1") Integer page,
                    @RequestParam(value = "size", defaultValue = "10") Integer size,
                    @RequestParam(value = "search", defaultValue = "") String search ) {
        
        ModelAndView mv = new ModelAndView(PREFIX + "index");
        Paginacion paginacion = busService.getPaginationList(page, size, search);
        mv.addObject("paginacion", paginacion);
        return mv;
    }
    
    @RequestMapping(value = "/guardar.json", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> guardar(@RequestBody BusDTO busDTO){
        try {
            busService.guardarBus(busDTO);
            return Helper.responseMapSuccess("Bus registrado exitosamente.");
        } catch (Exception e) {
            e.printStackTrace();
            return Helper.responseMapError(e.getMessage());
        }
    }
    
}
