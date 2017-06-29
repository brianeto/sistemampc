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
import proyectompc.entidades.Rol;
import proyectompc.facades.RolFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class RolControlador implements Serializable, Controlador<Rol>{

    private static final long serialVersionUID = 12L;
    @EJB
    private RolFacade rolFacade;
    private Rol rol;

    public Rol getRol(){
        return rol;
    }
    
    public void setRol(Rol rol){
        this.rol = rol;
    }

    public RolControlador(){
    }

    @PostConstruct
    public void iniciar(){
        rol = new Rol();
    }

    @Override
    public Rol getEntidad(Integer llavePrimaria) {
        return rolFacade.find(llavePrimaria);
    }
    
    public List<Rol> Rols(){
        return rolFacade.findAll();
    }
    
}
