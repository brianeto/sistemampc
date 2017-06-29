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
import proyectompc.entidades.MarcaVehiculo;
import proyectompc.facades.MarcaVehiculoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class MarcaVehiculoControlador implements Serializable, Controlador<MarcaVehiculo>{

    private static final long serialVersionUID = 12L;
    @EJB
    private MarcaVehiculoFacade marcavehiculoFacade;
    private MarcaVehiculo marcavehiculo;

    public MarcaVehiculo getMarcaVehiculo(){
        return marcavehiculo;
    }
    
    public void setMarcaVehiculo(MarcaVehiculo marcavehiculo){
        this.marcavehiculo = marcavehiculo;
    }

    public MarcaVehiculoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        marcavehiculo = new MarcaVehiculo();
    }

    @Override
    public MarcaVehiculo getEntidad(Integer llavePrimaria) {
        return marcavehiculoFacade.find(llavePrimaria);
    }
    
    public List<MarcaVehiculo> MarcaVehiculos(){
        return marcavehiculoFacade.findAll();
    }
    
}
