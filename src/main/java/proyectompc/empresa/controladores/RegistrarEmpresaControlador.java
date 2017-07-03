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
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import proyectompc.empresa.negocio.RegistrarEmpresa;
import proyectompc.entidades.ContactoEmpresa;
import proyectompc.entidades.Empresa;
import proyectompc.entidades.TelefonoEmpresa;
import proyectompc.entidades.Usuario;
import proyectompc.facades.EmpresaFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class RegistrarEmpresaControlador implements Serializable{

    private static final long serialVersionUID = 12L;
    @EJB
    private EmpresaFacade registrarEmpresa;
    
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
        FacesContext context = FacesContext.getCurrentInstance();
        int num = 0;
        if (registrarEmpresa.existeUsuario(usuario.getUsuario()) > 0) {
            context.addMessage(
                    "usuarioEmpresa",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El nombre de usuario ya se encuentra en uso."));
            num++;
        }
        if (num == 0) {
            String resultado = registrarEmpresa.registarEmpresa(usuario, empresa, contactoEmpresa);
            System.out.println(resultado);
            if (!resultado.isEmpty()) {
                String[] datos = {contactoEmpresa.getCorreoElectronico(), this.empresa.getRazonSocial(), resultado};
                if(registrarEmpresa.enviarMensaje(datos)==0){
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Registro exitoso", "El correo proporcionado es incorrecto por favor corregir el panel de contactos."));
                }else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Verifique su correo electrónico para habilitar el ingreso al sistema."));
                }
                this.setEmpresa(new Empresa());
                this.setContactoEmpresa(new ContactoEmpresa());
                this.setUsuario(new Usuario());
                this.repetirClave = new String();
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo realizar la acción."));
            }
        }
        RequestContext.getCurrentInstance().update("empresaFormularioRegistro");
    }
    
}
