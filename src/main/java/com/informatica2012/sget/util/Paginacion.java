/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.util;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class Paginacion implements Serializable {
    
    private Integer page;
    private Integer size;
    private Integer totalPage;
    private String search;
    private List items;
    
    public static Paginacion build(Integer page, Integer size, String search, Long totalRows, List items){
        Paginacion paginacion = new Paginacion();
        paginacion.setPage(page);
        paginacion.setSize(size);
        paginacion.setSearch(search);
        
        double t = (totalRows + 0.0)/size;
        paginacion.setTotalPage((int)Math.ceil(t));
        paginacion.setItems(items);
        return paginacion;
    }
    
    public Paginacion() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }    
    
}
