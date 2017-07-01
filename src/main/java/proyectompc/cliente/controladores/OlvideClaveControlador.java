/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.cliente.controladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import net.bootsfaces.utils.FacesMessages;
import org.primefaces.context.RequestContext;
import proyectompc.cliente.negocio.OlvideClave;
import proyectompc.entidades.Usuario;
import proyectompc.facades.UsuarioFacade;
import proyectompc.utilidades.UtilidadString;

/**
 *
 * @author Andres
 */
@Named(value = "olvideClaveControlador")
@SessionScoped
public class OlvideClaveControlador implements Serializable {

    private static final long serialVersionUID = 12345L;

    @EJB
    private OlvideClave olvideClave;
    @EJB
    private UsuarioFacade usuarioFacade;

    private String nombreUsuario;
    private String respuesta;
    private Usuario usuario;
    private boolean valido;
    
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}+$", message = "Contraseña requerida, mínimo 8 caracteres con un número.")
    private String clave;
    private String repetirClave;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    public String getRepetirClave() {
        return repetirClave;
    }

    public void setRepetirClave(String repetirClave) {
        this.repetirClave = repetirClave;
    }

    public OlvideClaveControlador() {
    }

    @PostConstruct
    public void iniciar() {
        nombreUsuario = new String();
        respuesta = new String();
        usuario = new Usuario();
        valido = false;
        clave = new String();
        repetirClave = new String();
    }

    public void asignarUsuario() {
        Usuario usuarioTemporal = olvideClave.getUsuario(nombreUsuario);
        if (usuarioTemporal.getUsuario()!=null) {
            this.setUsuario(usuarioTemporal);
            RequestContext.getCurrentInstance().update("formularioOlvideClave");
        } else {
            FacesMessages.error("No existe el usuario.");
        }
    }

    public void validar() {
        if (respuesta.equals(usuario.getRespuestaPreguntaSecreta())) {
            valido = true;
            RequestContext.getCurrentInstance().update("formularioOlvideClave");
        } else {
            FacesMessages.error("La respuesta a la pregunta es la correcta.");
        }
    }

    public void cambiarClave() {
        String claveTemp = repetirClave;
        usuario.setClave(UtilidadString.cifrarStringSha(claveTemp));
        usuarioFacade.edit(usuario);
        FacesMessages.info("Se ha cambiado la contraseña.");
        nombreUsuario = new String();
        clave = new String();
        respuesta = new String();
        usuario = new Usuario();
        valido = false;
        repetirClave = new String();
    }
}
