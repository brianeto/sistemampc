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
import proyectompc.empresa.negocio.RegistrarEmpresa;
import proyectompc.entidades.Empresa;
import proyectompc.entidades.TelefonoEmpresa;
import proyectompc.entidades.Usuario;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class RegistrarEmpresaControlador implements Serializable{

    private static final long serialVersionUID = 12L;
    @EJB
    private RegistrarEmpresa registrarEmpresa;
    
    private Usuario usuario;
    private Empresa empresa;
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
    
    
    public RegistrarEmpresaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        usuario = new Usuario();
        empresa = new Empresa();
        telefonoEmpresa = new TelefonoEmpresa();
        repetirClave = new String();
    }
    
    
    public void registrarEmpresa(){
        
    }
    
}
