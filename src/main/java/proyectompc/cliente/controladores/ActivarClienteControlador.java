/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.cliente.controladores;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import proyectompc.cliente.negocio.ActivarCliente;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class ActivarClienteControlador implements Serializable{

    private static final long serialVersionUID = 12L;
    @EJB
    private ActivarCliente activarcliente;

     private String hashUser;

    public String getHashUser() {
        return hashUser;
    }

    public void setHashUser(String hashUser) {
        this.hashUser = hashUser;
    }

    public ActivarClienteControlador(){
    }

    @PostConstruct
    public void iniciar() {
        hashUser = new String();
    }

    public void activar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = activarcliente.activarCliente(hashUser);
        if (resultado) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Usuario activado.","Su usuario ha sido activo con éxito."));
        }else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"Código de activación no válido.",""));
        }
    }
}
