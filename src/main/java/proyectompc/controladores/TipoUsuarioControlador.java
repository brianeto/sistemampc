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
import proyectompc.entidades.TipoUsuario;
import proyectompc.facades.TipoUsuarioFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TipoUsuarioControlador implements Serializable, Controlador<TipoUsuario>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TipoUsuarioFacade tipousuarioFacade;
    private TipoUsuario tipousuario;

    public TipoUsuario getTipoUsuario(){
        return tipousuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipousuario){
        this.tipousuario = tipousuario;
    }

    public TipoUsuarioControlador(){
    }

    @PostConstruct
    public void iniciar(){
        tipousuario = new TipoUsuario();
    }

    @Override
    public TipoUsuario getEntidad(Integer llavePrimaria) {
        return tipousuarioFacade.find(llavePrimaria);
    }
    
    public List<TipoUsuario> TipoUsuarios(){
        return tipousuarioFacade.findAll();
    }
    

    @FacesConverter(forClass = TipoUsuario.class)
    public class TipoUsuarioConvertidor extends Convertidor {
        
        public TipoUsuarioConvertidor(){
            this.nombreControlador = "tipoUsuarioControlador";
        }
    }
}
