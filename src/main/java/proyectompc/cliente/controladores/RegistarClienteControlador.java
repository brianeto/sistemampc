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
import org.primefaces.context.RequestContext;
import proyectompc.cliente.negocio.RegistrarCliente;
import proyectompc.entidades.Cliente;
import proyectompc.entidades.Usuario;
import proyectompc.utilidades.UtilidadDate;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class RegistarClienteControlador implements Serializable {

    private static final long serialVersionUID = 12L;
    @EJB
    private RegistrarCliente registrarCliente;

    private String dia;
    private Integer mes;
    private String anio;
    
    
    private Usuario usuario;
    private Cliente cliente;
    private String repetirClave;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getRepetirClave() {
        return repetirClave;
    }

    public void setRepetirClave(String repetirClave) {
        this.repetirClave = repetirClave;
    }
    
    public RegistarClienteControlador() {
    }
    
    @PostConstruct
    public void iniciar() {
        usuario = new Usuario();
        cliente = new Cliente();
        mes = 0;
        dia = new String();
        anio = new String();
        repetirClave = new String();
    }

    public void registrarCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        int num = 0;
        if (registrarCliente.existeCorreoElectronico(cliente.getCorreoElectronico()) > 0) {
            context.addMessage(
                    "correoNuevoCliente",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El correo electrónico ya se encuentra en uso."));
            num++;
        }
        if (registrarCliente.existeUsuario(usuario.getUsuario()) > 0) {
            context.addMessage(
                    "usuarioClienteRegistro",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El nombre de usuario ya se encuentra en uso."));
            num++;
        }
        if (registrarCliente.existeNumeroCedula(cliente.getNumeroCedula()) > 0) {
            context.addMessage(
                    "ncedula",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El número de cédula ya se encuentra en uso."));
            num++;
        }
        if (num == 0) {
            cliente.setFechaNacimiento(UtilidadDate.getFecha(Integer.valueOf(anio), mes, Integer.valueOf(dia)));
            String resultado = registrarCliente.registarCliente(usuario, cliente);
            if (!resultado.isEmpty()) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro exitoso", "Verifique su correo electrónico para habilitar el ingreso al sistema."));
                String[] datos = {cliente.getCorreoElectronico(), this.getCliente().getNombres(), this.getCliente().getApellidos(), resultado};
                registrarCliente.enviarMensaje(datos);
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo realizar la acción."));
            }
            this.setCliente(new Cliente());
            this.setUsuario(new Usuario());
            this.repetirClave = new String();
        }
        RequestContext.getCurrentInstance().update("registroClienteFormulario");
    }

}
