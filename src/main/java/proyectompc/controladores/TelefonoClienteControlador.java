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
import proyectompc.entidades.TelefonoCliente;
import proyectompc.facades.TelefonoClienteFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TelefonoClienteControlador implements Serializable, Controlador<TelefonoCliente>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TelefonoClienteFacade telefonoclienteFacade;
    private TelefonoCliente telefonocliente;

    public TelefonoCliente getTelefonoCliente(){
        return telefonocliente;
    }
    
    public void setTelefonoCliente(TelefonoCliente telefonocliente){
        this.telefonocliente = telefonocliente;
    }

    public TelefonoClienteControlador(){
    }

    @PostConstruct
    public void iniciar(){
        telefonocliente = new TelefonoCliente();
    }

    @Override
    public TelefonoCliente getEntidad(Integer llavePrimaria) {
        return telefonoclienteFacade.find(llavePrimaria);
    }
    
    public List<TelefonoCliente> TelefonoClientes(){
        return telefonoclienteFacade.findAll();
    }
    

    @FacesConverter(forClass = TelefonoCliente.class)
    public class TelefonoClienteConvertidor extends Convertidor {
        
        public TelefonoClienteConvertidor(){
            this.nombreControlador = "telefonoClienteControlador";
        }
    }
}
