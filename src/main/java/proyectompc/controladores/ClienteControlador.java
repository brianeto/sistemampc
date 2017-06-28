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
import proyectompc.entidades.Cliente;
import proyectompc.facades.ClienteFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class ClienteControlador implements Serializable, Controlador<Cliente>{

    private static final long serialVersionUID = 12L;
    @EJB
    private ClienteFacade clienteFacade;
    private Cliente cliente;

    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public ClienteControlador(){
    }

    @PostConstruct
    public void iniciar(){
        cliente = new Cliente();
    }

    @Override
    public Cliente getEntidad(Integer llavePrimaria) {
        return clienteFacade.find(llavePrimaria);
    }
    
    public List<Cliente> Clientes(){
        return clienteFacade.findAll();
    }
    

    @FacesConverter(forClass = Cliente.class)
    public class ClienteConvertidor extends Convertidor {
        
        public ClienteConvertidor(){
            this.nombreControlador = "clienteControlador";
        }
    }
}
