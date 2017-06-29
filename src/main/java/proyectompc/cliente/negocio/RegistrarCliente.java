/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.cliente.negocio;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.correo.Correo;
import proyectompc.correo.PlantillaCliente;
import proyectompc.entidades.Cliente;
import proyectompc.entidades.Estado;
import proyectompc.entidades.TipoUsuario;
import proyectompc.entidades.Usuario;
import proyectompc.utilidades.UtilidadString;
/**
 *
 * @author Andres
 */
@Stateless
public class RegistrarCliente{

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrarCliente(){
    }
    
    public int existeCorreoElectronico(String correoElectronico) {
        try {
            return getEntityManager().createNamedQuery("Cliente.findByCorreoElectronico").setParameter("correoElectronico", correoElectronico).getResultList().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }
    
    public int existeNumeroCedula(String numeroCedula) {
        try {
            return getEntityManager().createNamedQuery("Cliente.findByNumeroCedula").setParameter("numeroCedula", numeroCedula).getResultList().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }
    
    public String registarCliente(Usuario usuario, Cliente cliente) {
        try {
            Estado estado = new Estado(2);
            TipoUsuario tipoUsuario = new TipoUsuario(2);
            String claveCifrada = UtilidadString.cifrarStringSha(usuario.getClave());
            usuario.setEstadoId(estado);
            usuario.setClave(claveCifrada);
            usuario.setHashUser(UtilidadString.generarClave(15) + tipoUsuario.getId());
            usuario.setTipoUsuarioId(tipoUsuario);
            getEntityManager().persist(usuario);
            usuario = getUsuario(usuario.getHashUser());
            cliente.setUsuarioId(usuario);
            cliente.setFechaRegistro(new Date());
            cliente.setHashCliente(UtilidadString.generarClave(4)+usuario.getId());
            getEntityManager().persist(cliente);
            return usuario.getHashUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String();
    }
    
    public void enviarMensaje(String[] datos) {
        String titulo = "Usuario registrado con éxito";
        String contenido = "<div>" + datos[1] + " " + datos[2] + " le damos la bienvenida a <b style=\"color:#41b883\">MPC</b>.<hr />Para poder ingresar al aplicativo es necesario realizar la activación de su cuenta a través del siguiente enlace.<br /><br /><a href=\"http://localhost:8080/proyectompc/usuarios/activar.mpc?huk=" + datos[3] + "\" target=\"_blank\">Activar cuenta</a></div>";
        Correo.enviarCorreoHtml("Usuario registrado con éxito", PlantillaCliente.getContenido(titulo, contenido), datos[0]);
    }
    public void enviarMensajeNuevoUsuario(String[] datos) {
        String titulo = "Usuario registrado con éxito";
        String contenido = "<div>" + datos[1] + " " + datos[2] + " le damos la bienvenida a <b style=\"color:#41b883\">MPC</b>.<hr />Su clave de acceso es: <b>" + datos[3] + "</b> esta se podra cambiar posterior a su primer ingreso</div>";
        Correo.enviarCorreoHtml("Usuario registrado con éxito", PlantillaCliente.getContenido(titulo, contenido), datos[0]);
    }
    
    public Usuario getUsuario(String hashUser) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByHashUser").setParameter("hashUser", hashUser).getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }
}