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
import proyectompc.entidades.MantenimientoDocumento;
import proyectompc.facades.MantenimientoDocumentoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class MantenimientoDocumentoControlador implements Serializable, Controlador<MantenimientoDocumento>{

    private static final long serialVersionUID = 12L;
    @EJB
    private MantenimientoDocumentoFacade mantenimientodocumentoFacade;
    private MantenimientoDocumento mantenimientodocumento;

    public MantenimientoDocumento getMantenimientoDocumento(){
        return mantenimientodocumento;
    }
    
    public void setMantenimientoDocumento(MantenimientoDocumento mantenimientodocumento){
        this.mantenimientodocumento = mantenimientodocumento;
    }

    public MantenimientoDocumentoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        mantenimientodocumento = new MantenimientoDocumento();
    }

    @Override
    public MantenimientoDocumento getEntidad(Integer llavePrimaria) {
        return mantenimientodocumentoFacade.find(llavePrimaria);
    }
    
    public List<MantenimientoDocumento> MantenimientoDocumentos(){
        return mantenimientodocumentoFacade.findAll();
    }
    
}
