/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.cliente.negocio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import proyectompc.correo.Correo;
import proyectompc.correo.PlantillaCliente;
import proyectompc.entidades.Usuario;
import proyectompc.utilidades.UtilidadString;

/**
 *
 * @author Andres
 */
@Stateless
public class OlvideClave {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public String cambioClave(String ce) {
        try {
            TypedQuery<Usuario> u = getEntityManager().createNamedQuery("Usuario.findByCorreoElectronico", Usuario.class).setParameter("correoElectronico", ce);
            List<Usuario> usuarios = u.getResultList();
            if (usuarios.size() > 0) {
                String clave = UtilidadString.generarClave(3);
                Usuario usuario = usuarios.get(0);
                usuario.setClave(UtilidadString.cifrarStringSha(clave));
                String titulo = "Cambio de contraseña realizado";
                String contenido = "<div>Su nueva es: <b>" + clave + "</b> esta se podra cambiar posterior a su primer ingreso</div>";
                return "Cambio de contraseña realizado por favor verifique su correo electrónico.";
            }
            return "No se encuentra un usuario asociado al correo electrónico.";
        } catch (Exception e) {
        }
        return "No se pudo realizar la acción.";
    }
}