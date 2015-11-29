/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.UsuarioDTO;
import com.informatica2012.sget.entity.Usuario;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.util.Paginacion;

/**
 *
 * @author Hugo
 */
public interface UsuarioService extends BaseService<Usuario, Integer>{
    
    public void guardarUsuario(UsuarioDTO usuarioDTO) throws BusinessException;
    public void actualizarUsuario(UsuarioDTO usuarioDTO) throws BusinessException;
    public Usuario buscarPorTrabajadorId(Integer trabajadorId);
    public Paginacion getPaginationList(Integer page, Integer size, String search);
    
}
