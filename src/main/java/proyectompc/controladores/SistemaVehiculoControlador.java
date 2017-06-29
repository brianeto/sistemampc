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
import proyectompc.entidades.SistemaVehiculo;
import proyectompc.facades.SistemaVehiculoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class SistemaVehiculoControlador implements Serializable, Controlador<SistemaVehiculo>{

    private static final long serialVersionUID = 12L;
    @EJB
    private SistemaVehiculoFacade sistemavehiculoFacade;
    private SistemaVehiculo sistemavehiculo;

    public SistemaVehiculo getSistemaVehiculo(){
        return sistemavehiculo;
    }
    
    public void setSistemaVehiculo(SistemaVehiculo sistemavehiculo){
        this.sistemavehiculo = sistemavehiculo;
    }

    public SistemaVehiculoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        sistemavehiculo = new SistemaVehiculo();
    }

    @Override
    public SistemaVehiculo getEntidad(Integer llavePrimaria) {
        return sistemavehiculoFacade.find(llavePrimaria);
    }
    
    public List<SistemaVehiculo> SistemaVehiculos(){
        return sistemavehiculoFacade.findAll();
    }
    
}
