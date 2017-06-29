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
import proyectompc.entidades.CalificacionEmpleado;
import proyectompc.facades.CalificacionEmpleadoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class CalificacionEmpleadoControlador implements Serializable, Controlador<CalificacionEmpleado>{

    private static final long serialVersionUID = 12L;
    @EJB
    private CalificacionEmpleadoFacade calificacionempleadoFacade;
    private CalificacionEmpleado calificacionempleado;

    public CalificacionEmpleado getCalificacionEmpleado(){
        return calificacionempleado;
    }
    
    public void setCalificacionEmpleado(CalificacionEmpleado calificacionempleado){
        this.calificacionempleado = calificacionempleado;
    }

    public CalificacionEmpleadoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        calificacionempleado = new CalificacionEmpleado();
    }

    @Override
    public CalificacionEmpleado getEntidad(Integer llavePrimaria) {
        return calificacionempleadoFacade.find(llavePrimaria);
    }
    
    public List<CalificacionEmpleado> CalificacionEmpleados(){
        return calificacionempleadoFacade.findAll();
    }
    
}
