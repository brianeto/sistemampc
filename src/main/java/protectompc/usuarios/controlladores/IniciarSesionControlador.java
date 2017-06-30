/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protectompc.usuarios.controlladores;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author miguelangel
 */
@Named(value = "iniciarSesionControlador")
@RequestScoped
public class IniciarSesionControlador implements Serializable{
    private String usuario;
    private String contraseña;
    
    public IniciarSesionControlador() {
    }
    
    @PostConstruct
    public void IniciarSesion (){
        usuario = new String();
        contraseña =  new String();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
      
}
