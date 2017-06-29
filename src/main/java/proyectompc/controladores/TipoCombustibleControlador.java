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
import proyectompc.entidades.TipoCombustible;
import proyectompc.facades.TipoCombustibleFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TipoCombustibleControlador implements Serializable, Controlador<TipoCombustible>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TipoCombustibleFacade tipocombustibleFacade;
    private TipoCombustible tipocombustible;

    public TipoCombustible getTipoCombustible(){
        return tipocombustible;
    }
    
    public void setTipoCombustible(TipoCombustible tipocombustible){
        this.tipocombustible = tipocombustible;
    }

    public TipoCombustibleControlador(){
    }

    @PostConstruct
    public void iniciar(){
        tipocombustible = new TipoCombustible();
    }

    @Override
    public TipoCombustible getEntidad(Integer llavePrimaria) {
        return tipocombustibleFacade.find(llavePrimaria);
    }
    
    public List<TipoCombustible> TipoCombustibles(){
        return tipocombustibleFacade.findAll();
    }
    
}
