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
import proyectompc.entidades.TipoVehiculo;
import proyectompc.facades.TipoVehiculoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TipoVehiculoControlador implements Serializable, Controlador<TipoVehiculo>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TipoVehiculoFacade tipovehiculoFacade;
    private TipoVehiculo tipovehiculo;

    public TipoVehiculo getTipoVehiculo(){
        return tipovehiculo;
    }
    
    public void setTipoVehiculo(TipoVehiculo tipovehiculo){
        this.tipovehiculo = tipovehiculo;
    }

    public TipoVehiculoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        tipovehiculo = new TipoVehiculo();
    }

    @Override
    public TipoVehiculo getEntidad(Integer llavePrimaria) {
        return tipovehiculoFacade.find(llavePrimaria);
    }
    
    public List<TipoVehiculo> TipoVehiculos(){
        return tipovehiculoFacade.findAll();
    }
    
}
