/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.util;

import com.informatica2012.sget.config.Constantes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo
 */
public class Helper {
    
    private static SimpleDateFormat df;
    
    static {
        df = new SimpleDateFormat(Constantes.DATE_FORMAT);
    }
    
    public static String formatDate(Date date){
        return df.format(date);
    }
    
    public static Date parseDate(String stringDate) {
        Date date;
        
        try {
            date = df.parse(stringDate);
        } catch (ParseException ex) {
            date = new Date();
        }
        
        return date;
    }
    
    public static Map<String, Object> responseMapSuccess(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "success");
        map.put("msg", msg);
        return map;
    }
    
    public static Map<String, Object> responseMapError(String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "error");
        map.put("msg", msg);
        return map;
    }
    
}
