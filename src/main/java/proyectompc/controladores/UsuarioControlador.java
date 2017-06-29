/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.controladores;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import proyectompc.core.Controlador;
import proyectompc.core.Convertidor;
import javax.faces.convert.FacesConverter;
import proyectompc.entidades.Usuario;
import proyectompc.facades.UsuarioFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class UsuarioControlador implements Serializable, Controlador<Usuario>{

    private static final long serialVersionUID = 12L;
    @EJB
    private UsuarioFacade usuarioFacade;
    private Usuario usuario;

    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public UsuarioControlador(){
    }

    @PostConstruct
    public void iniciar(){
        usuario = new Usuario();
    }

    @Override
    public Usuario getEntidad(Integer llavePrimaria) {
        return usuarioFacade.find(llavePrimaria);
    }
    
    public List<Usuario> Usuarios(){
        return usuarioFacade.findAll();
    }
    
}
