/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hugo
 */
@Controller
public class HomeController {
    
    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/login.html")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error){
        ModelAndView mv = new ModelAndView("login");
        
        if (error != null) {
            mv.addObject("error", "Credenciales incorrectos");
        }
        
        return mv;
    }
    
}
