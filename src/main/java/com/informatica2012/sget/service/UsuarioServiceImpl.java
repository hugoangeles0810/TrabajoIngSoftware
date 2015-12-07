/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.informatica2012.sget.service;

import com.informatica2012.sget.dto.UsuarioDTO;
import com.informatica2012.sget.entity.Usuario;
import com.informatica2012.sget.exception.BusinessException;
import com.informatica2012.sget.repository.UsuarioRepository;
import com.informatica2012.sget.util.Criterio;
import com.informatica2012.sget.util.EncryptUtil;
import com.informatica2012.sget.util.Paginacion;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hugo
 */
@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> 
                implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        super(usuarioRepository);
    }
    
    @Override
    public void guardarUsuario(UsuarioDTO usuarioDTO) throws BusinessException {
        if (esGuardarValido(usuarioDTO)) {
            Usuario usuario = usuarioDTO.getUsuarioEntity();
            usuario.setClave(EncryptUtil.md5(usuario.getClave()));
            usuarioRepository.save(usuario);
        }
    }
    
    @Override
    public void actualizarUsuario(UsuarioDTO usuarioDTO) throws BusinessException {
        Usuario usuario = usuarioRepository.get(usuarioDTO.getId());
        if (!usuario.getClave().equals(usuarioDTO.getClave())) {
            usuario.setClave(EncryptUtil.md5(usuarioDTO.getClave()));
        }
        usuarioRepository.update(usuario);
    }
    
    private boolean esGuardarValido(UsuarioDTO usuarioDTO) throws BusinessException{
        
        if (buscarPorTrabajadorId(usuarioDTO.getTrabajador()) != null) {
            throw new BusinessException("El trabajador seleccionado ya tiene un usuario");
        }
       
        return true;
    }
    
    @Override
    public Usuario buscarPorTrabajadorId(Integer trabajadorId){
        Criterio criterio = Criterio.forClass(Usuario.class);
        criterio.createCriteria("trabajador")
                .add(Restrictions.eq("id", trabajadorId));
        
        List<Usuario> usuarios = usuarioRepository.searchForCriteria(criterio);
        if (usuarios != null && !usuarios.isEmpty()) {
            return usuarios.get(0);
        }
        
        return null;
    }
    
    @Override
    public Paginacion getPaginationList(Integer page, Integer size, String search) {
        Criterio criterio = Criterio.forClass(Usuario.class);
        
        Long totalRows = usuarioRepository.countResultForCriteria(criterio);
        
        criterio.setFirstResult(size*(page-1));
        criterio.setMaxResults(size);
        
        List<Usuario> items = usuarioRepository.searchForCriteria(criterio);
        
        return Paginacion.build(page, size, search, totalRows, items);
        
    }
    
}
