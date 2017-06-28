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
import proyectompc.entidades.Prioridad;
import proyectompc.facades.PrioridadFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class PrioridadControlador implements Serializable, Controlador<Prioridad>{

    private static final long serialVersionUID = 12L;
    @EJB
    private PrioridadFacade prioridadFacade;
    private Prioridad prioridad;

    public Prioridad getPrioridad(){
        return prioridad;
    }
    
    public void setPrioridad(Prioridad prioridad){
        this.prioridad = prioridad;
    }

    public PrioridadControlador(){
    }

    @PostConstruct
    public void iniciar(){
        prioridad = new Prioridad();
    }

    @Override
    public Prioridad getEntidad(Integer llavePrimaria) {
        return prioridadFacade.find(llavePrimaria);
    }
    
    public List<Prioridad> Prioridads(){
        return prioridadFacade.findAll();
    }
    

    @FacesConverter(forClass = Prioridad.class)
    public class PrioridadConvertidor extends Convertidor {
        
        public PrioridadConvertidor(){
            this.nombreControlador = "prioridadControlador";
        }
    }
}
