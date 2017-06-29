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
import proyectompc.entidades.Empleado;
import proyectompc.facades.EmpleadoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class EmpleadoControlador implements Serializable, Controlador<Empleado>{

    private static final long serialVersionUID = 12L;
    @EJB
    private EmpleadoFacade empleadoFacade;
    private Empleado empleado;

    public Empleado getEmpleado(){
        return empleado;
    }
    
    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public EmpleadoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        empleado = new Empleado();
    }

    @Override
    public Empleado getEntidad(Integer llavePrimaria) {
        return empleadoFacade.find(llavePrimaria);
    }
    
    public List<Empleado> Empleados(){
        return empleadoFacade.findAll();
    }
    
}
