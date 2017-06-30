/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.empresa.controladores;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import org.primefaces.event.FlowEvent;
import proyectompc.empresa.negocio.RegistrarEmpresa;
import proyectompc.entidades.ContactoEmpresa;
import proyectompc.entidades.Empresa;
import proyectompc.entidades.TelefonoEmpresa;
import proyectompc.entidades.Usuario;

/**
 *
 * @author Andres
 */
@Named
@ViewScoped
public class RegistrarEmpresaControlador implements Serializable{

    private static final long serialVersionUID = 12L;
    @EJB
    private RegistrarEmpresa registrarEmpresa;
    
    private boolean skip;
    private Usuario usuario;
    private Empresa empresa;
    private ContactoEmpresa contactoEmpresa;
    private TelefonoEmpresa telefonoEmpresa;
    private String repetirClave; 
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TelefonoEmpresa getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(TelefonoEmpresa telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getRepetirClave() {
        return repetirClave;
    }

    public void setRepetirClave(String repetirClave) {
        this.repetirClave = repetirClave;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public ContactoEmpresa getContactoEmpresa() {
        return contactoEmpresa;
    }

    public void setContactoEmpresa(ContactoEmpresa contactoEmpresa) {
        this.contactoEmpresa = contactoEmpresa;
    }
    
    public RegistrarEmpresaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        usuario = new Usuario();
        empresa = new Empresa();
        telefonoEmpresa = new TelefonoEmpresa();
        repetirClave = new String();
        skip = false;
        contactoEmpresa = new ContactoEmpresa();
    }
    
    
    public void registrarEmpresa(){
        
    }
    
    
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}
