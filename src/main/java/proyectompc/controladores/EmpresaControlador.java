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
import proyectompc.entidades.Empresa;
import proyectompc.facades.EmpresaFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class EmpresaControlador implements Serializable, Controlador<Empresa>{

    private static final long serialVersionUID = 12L;
    @EJB
    private EmpresaFacade empresaFacade;
    private Empresa empresa;

    public Empresa getEmpresa(){
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa){
        this.empresa = empresa;
    }

    public EmpresaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        empresa = new Empresa();
    }

    @Override
    public Empresa getEntidad(Integer llavePrimaria) {
        return empresaFacade.find(llavePrimaria);
    }
    
    public List<Empresa> Empresas(){
        return empresaFacade.findAll();
    }
    
}
