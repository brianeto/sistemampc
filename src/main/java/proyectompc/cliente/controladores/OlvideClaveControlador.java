/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.cliente.controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import proyectompc.cliente.negocio.OlvideClave;

/**
 *
 * @author Andres
 */
@Named(value = "olvideClaveControlador")
@RequestScoped
public class OlvideClaveControlador implements Serializable{

    private static final long serialVersionUID = 12345L;

    @EJB
    private OlvideClave olvideClave;

    @Pattern(regexp = "[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]+", message = "Correo electrónico no válido.")
    private String correoElectronico;
    private String usuario;

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public OlvideClaveControlador() {
    }

    @PostConstruct
    public void iniciar() {
        correoElectronico = new String();
        usuario = new String();
    }

    public void actualizarClave() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(olvideClave.cambioClave(correoElectronico, usuario)));
        this.setCorreoElectronico(new String());
    }

    
}
