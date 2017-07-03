/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.empresa.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.bootsfaces.utils.FacesMessages;
import proyectompc.correo.Correo;
import proyectompc.correo.PlantillaCliente;
import proyectompc.entidades.ContactoEmpresa;
import proyectompc.entidades.Empresa;
import proyectompc.entidades.Estado;
import proyectompc.entidades.TipoUsuario;
import proyectompc.entidades.Usuario;
import proyectompc.utilidades.UtilidadString;

/**
 *
 * @author Andres
 */
@Stateless
public class RegistrarEmpresa {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrarEmpresa() {
    }

    public int existeUsuario(String usuario) {
        try {
            return getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getResultList().size();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public Usuario getUsuario(String usuario) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }

    public Empresa getEmpresa(String hashEmpresa) {
        try {
            return (Empresa) getEntityManager().createNamedQuery("Empresa.findByHashEmpresa").setParameter("hashEmpresa", hashEmpresa).getSingleResult();
        } catch (Exception e) {
            return new Empresa();
        }
    }

    public String registarEmpresa(Usuario usuario, Empresa empresa, ContactoEmpresa contacto) {
        try {
            System.out.println(usuario.getClave());
            System.out.println(usuario.getUsuario());
            System.out.println(usuario.getRespuestaPreguntaSecreta());
            System.out.println(usuario.getPreguntaSecretaId().getPregunta() );
            usuario.setEstadoId(new Estado(2));
            usuario.setClave(UtilidadString.cifrarStringSha(usuario.getClave()));
            usuario.setHashUser(UtilidadString.generarClave(15) + 2);
            usuario.setTipoUsuarioId(new TipoUsuario(3));
            getEntityManager().persist(usuario);
            Usuario u = getUsuario(usuario.getHashUser());
            empresa.setUsuarioId(u);
            empresa.setHashEmpresa(UtilidadString.generarClave(4) + u.getId());
            getEntityManager().persist(empresa);
            contacto.setEmpresaId(getEmpresa(empresa.getHashEmpresa()));
            getEntityManager().persist(contacto);
            return usuario.getHashUser();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new String();
    }
    
    public void enviarMensaje(String[] datos) {
        System.out.println(datos[0]);
        System.out.println(datos[1]);
        System.out.println(datos[2]);
        String titulo = "Usuario registrado con éxito";
        String contenido = "<div>" + datos[1] + " le damos la bienvenida a <b style=\"color:#41b883\">MPC</b>.<hr />Para poder ingresar al aplicativo es necesario realizar la activación de su cuenta a través del siguiente enlace.<br /><br /><a href=\"http://localhost:8080/proyectompc/activar.mpc?huk=" + datos[2] + "\" target=\"_blank\">Activar cuenta</a></div>";
        Correo.enviarCorreoHtml("Registro exitoso", PlantillaCliente.getContenido(titulo, contenido), datos[0]);
    }

}
