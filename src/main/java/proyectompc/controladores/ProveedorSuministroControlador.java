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
import proyectompc.entidades.ProveedorSuministro;
import proyectompc.facades.ProveedorSuministroFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class ProveedorSuministroControlador implements Serializable, Controlador<ProveedorSuministro>{

    private static final long serialVersionUID = 12L;
    @EJB
    private ProveedorSuministroFacade proveedorsuministroFacade;
    private ProveedorSuministro proveedorsuministro;

    public ProveedorSuministro getProveedorSuministro(){
        return proveedorsuministro;
    }
    
    public void setProveedorSuministro(ProveedorSuministro proveedorsuministro){
        this.proveedorsuministro = proveedorsuministro;
    }

    public ProveedorSuministroControlador(){
    }

    @PostConstruct
    public void iniciar(){
        proveedorsuministro = new ProveedorSuministro();
    }

    @Override
    public ProveedorSuministro getEntidad(Integer llavePrimaria) {
        return proveedorsuministroFacade.find(llavePrimaria);
    }
    
    public List<ProveedorSuministro> ProveedorSuministros(){
        return proveedorsuministroFacade.findAll();
    }
    

    @FacesConverter(forClass = ProveedorSuministro.class)
    public class ProveedorSuministroConvertidor extends Convertidor {
        
        public ProveedorSuministroConvertidor(){
            this.nombreControlador = "proveedorSuministroControlador";
        }
    }
}
