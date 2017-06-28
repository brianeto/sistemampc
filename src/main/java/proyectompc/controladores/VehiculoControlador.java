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
import proyectompc.entidades.Vehiculo;
import proyectompc.facades.VehiculoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class VehiculoControlador implements Serializable, Controlador<Vehiculo>{

    private static final long serialVersionUID = 12L;
    @EJB
    private VehiculoFacade vehiculoFacade;
    private Vehiculo vehiculo;

    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    public VehiculoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        vehiculo = new Vehiculo();
    }

    @Override
    public Vehiculo getEntidad(Integer llavePrimaria) {
        return vehiculoFacade.find(llavePrimaria);
    }
    
    public List<Vehiculo> Vehiculos(){
        return vehiculoFacade.findAll();
    }
    

    @FacesConverter(forClass = Vehiculo.class)
    public class VehiculoConvertidor extends Convertidor {
        
        public VehiculoConvertidor(){
            this.nombreControlador = "vehiculoControlador";
        }
    }
}
