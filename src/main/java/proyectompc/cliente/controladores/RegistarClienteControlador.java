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
import proyectompc.cliente.negocio.RegistrarCliente;
import proyectompc.entidades.Cliente;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class RegistarClienteControlador implements Serializable{

    private static final long serialVersionUID = 12L;
    @EJB
    private RegistrarCliente registarcliente;
    
    private String usuario;
    private String clave;
    private String respuestaSecreta;
    
    private Cliente cliente;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRespuestaSecreta() {
        return respuestaSecreta;
    }

    public void setRespuestaSecreta(String respuestaSecreta) {
        this.respuestaSecreta = respuestaSecreta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public RegistarClienteControlador(){
    }

    @PostConstruct
    public void iniciar(){
        respuestaSecreta = new String();
        clave = new String();
        usuario = new String();
        cliente = new Cliente();
    }
    
    
}
