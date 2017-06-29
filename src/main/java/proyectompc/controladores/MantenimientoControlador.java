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
import proyectompc.entidades.Mantenimiento;
import proyectompc.facades.MantenimientoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class MantenimientoControlador implements Serializable, Controlador<Mantenimiento>{

    private static final long serialVersionUID = 12L;
    @EJB
    private MantenimientoFacade mantenimientoFacade;
    private Mantenimiento mantenimiento;

    public Mantenimiento getMantenimiento(){
        return mantenimiento;
    }
    
    public void setMantenimiento(Mantenimiento mantenimiento){
        this.mantenimiento = mantenimiento;
    }

    public MantenimientoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        mantenimiento = new Mantenimiento();
    }

    @Override
    public Mantenimiento getEntidad(Integer llavePrimaria) {
        return mantenimientoFacade.find(llavePrimaria);
    }
    
    public List<Mantenimiento> Mantenimientos(){
        return mantenimientoFacade.findAll();
    }
    
}
