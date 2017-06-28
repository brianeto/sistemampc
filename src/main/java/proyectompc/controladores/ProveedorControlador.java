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
import proyectompc.entidades.Proveedor;
import proyectompc.facades.ProveedorFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class ProveedorControlador implements Serializable, Controlador<Proveedor>{

    private static final long serialVersionUID = 12L;
    @EJB
    private ProveedorFacade proveedorFacade;
    private Proveedor proveedor;

    public Proveedor getProveedor(){
        return proveedor;
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    public ProveedorControlador(){
    }

    @PostConstruct
    public void iniciar(){
        proveedor = new Proveedor();
    }

    @Override
    public Proveedor getEntidad(Integer llavePrimaria) {
        return proveedorFacade.find(llavePrimaria);
    }
    
    public List<Proveedor> Proveedors(){
        return proveedorFacade.findAll();
    }
    

    @FacesConverter(forClass = Proveedor.class)
    public class ProveedorConvertidor extends Convertidor {
        
        public ProveedorConvertidor(){
            this.nombreControlador = "proveedorControlador";
        }
    }
}
