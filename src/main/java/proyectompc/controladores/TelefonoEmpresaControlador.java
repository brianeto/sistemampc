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
import proyectompc.entidades.TelefonoEmpresa;
import proyectompc.facades.TelefonoEmpresaFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class TelefonoEmpresaControlador implements Serializable, Controlador<TelefonoEmpresa>{

    private static final long serialVersionUID = 12L;
    @EJB
    private TelefonoEmpresaFacade telefonoempresaFacade;
    private TelefonoEmpresa telefonoempresa;

    public TelefonoEmpresa getTelefonoEmpresa(){
        return telefonoempresa;
    }
    
    public void setTelefonoEmpresa(TelefonoEmpresa telefonoempresa){
        this.telefonoempresa = telefonoempresa;
    }

    public TelefonoEmpresaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        telefonoempresa = new TelefonoEmpresa();
    }

    @Override
    public TelefonoEmpresa getEntidad(Integer llavePrimaria) {
        return telefonoempresaFacade.find(llavePrimaria);
    }
    
    public List<TelefonoEmpresa> TelefonoEmpresas(){
        return telefonoempresaFacade.findAll();
    }
    
}
