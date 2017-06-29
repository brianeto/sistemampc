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
import proyectompc.entidades.TelefonoProveedor;
import proyectompc.facades.TelefonoProveedorFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TelefonoProveedorControlador implements Serializable, Controlador<TelefonoProveedor>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TelefonoProveedorFacade telefonoproveedorFacade;
    private TelefonoProveedor telefonoproveedor;

    public TelefonoProveedor getTelefonoProveedor(){
        return telefonoproveedor;
    }
    
    public void setTelefonoProveedor(TelefonoProveedor telefonoproveedor){
        this.telefonoproveedor = telefonoproveedor;
    }

    public TelefonoProveedorControlador(){
    }

    @PostConstruct
    public void iniciar(){
        telefonoproveedor = new TelefonoProveedor();
    }

    @Override
    public TelefonoProveedor getEntidad(Integer llavePrimaria) {
        return telefonoproveedorFacade.find(llavePrimaria);
    }
    
    public List<TelefonoProveedor> TelefonoProveedors(){
        return telefonoproveedorFacade.findAll();
    }
    
}
