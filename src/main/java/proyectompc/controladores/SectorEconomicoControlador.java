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
import proyectompc.entidades.SectorEconomico;
import proyectompc.facades.SectorEconomicoFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class SectorEconomicoControlador implements Serializable, Controlador<SectorEconomico>{

    private static final long serialVersionUID = 12L;
    @EJB
    private SectorEconomicoFacade sectoreconomicoFacade;
    private SectorEconomico sectoreconomico;

    public SectorEconomico getSectorEconomico(){
        return sectoreconomico;
    }
    
    public void setSectorEconomico(SectorEconomico sectoreconomico){
        this.sectoreconomico = sectoreconomico;
    }

    public SectorEconomicoControlador(){
    }

    @PostConstruct
    public void iniciar(){
        sectoreconomico = new SectorEconomico();
    }

    @Override
    public SectorEconomico getEntidad(Integer llavePrimaria) {
        return sectoreconomicoFacade.find(llavePrimaria);
    }
    
    public List<SectorEconomico> SectorEconomicos(){
        return sectoreconomicoFacade.findAll();
    }
    
}
