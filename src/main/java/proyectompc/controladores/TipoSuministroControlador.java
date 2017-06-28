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
import proyectompc.entidades.TipoSuministro;
import proyectompc.facades.TipoSuministroFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TipoSuministroControlador implements Serializable, Controlador<TipoSuministro>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TipoSuministroFacade tiposuministroFacade;
    private TipoSuministro tiposuministro;

    public TipoSuministro getTipoSuministro(){
        return tiposuministro;
    }
    
    public void setTipoSuministro(TipoSuministro tiposuministro){
        this.tiposuministro = tiposuministro;
    }

    public TipoSuministroControlador(){
    }

    @PostConstruct
    public void iniciar(){
        tiposuministro = new TipoSuministro();
    }

    @Override
    public TipoSuministro getEntidad(Integer llavePrimaria) {
        return tiposuministroFacade.find(llavePrimaria);
    }
    
    public List<TipoSuministro> TipoSuministros(){
        return tiposuministroFacade.findAll();
    }
    

    @FacesConverter(forClass = TipoSuministro.class)
    public class TipoSuministroConvertidor extends Convertidor {
        
        public TipoSuministroConvertidor(){
            this.nombreControlador = "tipoSuministroControlador";
        }
    }
}
