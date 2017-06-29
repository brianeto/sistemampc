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
import proyectompc.entidades.Orden;
import proyectompc.facades.OrdenFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class OrdenControlador implements Serializable, Controlador<Orden>{

    private static final long serialVersionUID = 12L;
    @EJB
    private OrdenFacade ordenFacade;
    private Orden orden;

    public Orden getOrden(){
        return orden;
    }
    
    public void setOrden(Orden orden){
        this.orden = orden;
    }

    public OrdenControlador(){
    }

    @PostConstruct
    public void iniciar(){
        orden = new Orden();
    }

    @Override
    public Orden getEntidad(Integer llavePrimaria) {
        return ordenFacade.find(llavePrimaria);
    }
    
    public List<Orden> Ordens(){
        return ordenFacade.findAll();
    }
    
}
