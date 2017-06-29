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
import proyectompc.entidades.Estado;
import proyectompc.facades.EstadoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class EstadoControlador implements Serializable, Controlador<Estado>{

    private static final long serialVersionUID = 12L;
    @EJB
    private EstadoFacade estadoFacade;
    private Estado estado;

    public Estado getEstado(){
        return estado;
    }
    
    public void setEstado(Estado estado){
        this.estado = estado;
    }

    public EstadoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        estado = new Estado();
    }

    @Override
    public Estado getEntidad(Integer llavePrimaria) {
        return estadoFacade.find(llavePrimaria);
    }
    
    public List<Estado> Estados(){
        return estadoFacade.findAll();
    }
    
}
