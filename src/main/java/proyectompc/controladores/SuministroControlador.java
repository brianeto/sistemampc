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
import proyectompc.entidades.Suministro;
import proyectompc.facades.SuministroFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class SuministroControlador implements Serializable, Controlador<Suministro>{

    private static final long serialVersionUID = 12L;
    @EJB
    private SuministroFacade suministroFacade;
    private Suministro suministro;

    public Suministro getSuministro(){
        return suministro;
    }
    
    public void setSuministro(Suministro suministro){
        this.suministro = suministro;
    }

    public SuministroControlador(){
    }

    @PostConstruct
    public void iniciar(){
        suministro = new Suministro();
    }

    @Override
    public Suministro getEntidad(Integer llavePrimaria) {
        return suministroFacade.find(llavePrimaria);
    }
    
    public List<Suministro> Suministros(){
        return suministroFacade.findAll();
    }
    
}
