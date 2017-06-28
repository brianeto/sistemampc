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
import proyectompc.entidades.TipoTelefono;
import proyectompc.facades.TipoTelefonoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TipoTelefonoControlador implements Serializable, Controlador<TipoTelefono>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TipoTelefonoFacade tipotelefonoFacade;
    private TipoTelefono tipotelefono;

    public TipoTelefono getTipoTelefono(){
        return tipotelefono;
    }
    
    public void setTipoTelefono(TipoTelefono tipotelefono){
        this.tipotelefono = tipotelefono;
    }

    public TipoTelefonoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        tipotelefono = new TipoTelefono();
    }

    @Override
    public TipoTelefono getEntidad(Integer llavePrimaria) {
        return tipotelefonoFacade.find(llavePrimaria);
    }
    
    public List<TipoTelefono> TipoTelefonos(){
        return tipotelefonoFacade.findAll();
    }
    

    @FacesConverter(forClass = TipoTelefono.class)
    public class TipoTelefonoConvertidor extends Convertidor {
        
        public TipoTelefonoConvertidor(){
            this.nombreControlador = "tipoTelefonoControlador";
        }
    }
}
