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
import proyectompc.entidades.Permiso;
import proyectompc.facades.PermisoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class PermisoControlador implements Serializable, Controlador<Permiso>{

    private static final long serialVersionUID = 12L;
    @EJB
    private PermisoFacade permisoFacade;
    private Permiso permiso;

    public Permiso getPermiso(){
        return permiso;
    }
    
    public void setPermiso(Permiso permiso){
        this.permiso = permiso;
    }

    public PermisoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        permiso = new Permiso();
    }

    @Override
    public Permiso getEntidad(Integer llavePrimaria) {
        return permisoFacade.find(llavePrimaria);
    }
    
    public List<Permiso> Permisos(){
        return permisoFacade.findAll();
    }
    
}
