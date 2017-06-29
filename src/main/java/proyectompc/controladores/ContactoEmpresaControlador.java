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
import proyectompc.entidades.ContactoEmpresa;
import proyectompc.facades.ContactoEmpresaFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class ContactoEmpresaControlador implements Serializable, Controlador<ContactoEmpresa>{

    private static final long serialVersionUID = 12L;
    @EJB
    private ContactoEmpresaFacade contactoempresaFacade;
    private ContactoEmpresa contactoempresa;

    public ContactoEmpresa getContactoEmpresa(){
        return contactoempresa;
    }
    
    public void setContactoEmpresa(ContactoEmpresa contactoempresa){
        this.contactoempresa = contactoempresa;
    }

    public ContactoEmpresaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        contactoempresa = new ContactoEmpresa();
    }

    @Override
    public ContactoEmpresa getEntidad(Integer llavePrimaria) {
        return contactoempresaFacade.find(llavePrimaria);
    }
    
    public List<ContactoEmpresa> ContactoEmpresas(){
        return contactoempresaFacade.findAll();
    }
    
}
