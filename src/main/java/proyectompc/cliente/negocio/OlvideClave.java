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

    public String cambioClave(String ce, String usuario) {
        try {
            List<Object[]> objetos = getEntityManager().createNativeQuery("select c.usuario_id, c.correo_electronico from clientes c where c.correo_electronico = ? and c.usuario_id like (select u.id from usuarios u where u.usuario = '?')")
                    .setParameter(1, ce)
                    .setParameter(2, usuario).getResultList();
            String clave = UtilidadString.generarClave(3);
            String titulo = "Cambio de contraseña realizado";
            String contenido = "<div>Su nueva es: <b>" + clave + "</b> esta se podra cambiar posterior a su primer ingreso</div>";
            if (objetos.size() > 0) {
                Usuario u = getEntityManager().createNamedQuery("Usuario.findById", Usuario.class).setParameter("id", objetos.get(0)[0]).getSingleResult();
                u.setClave(UtilidadString.cifrarStringSha(clave));
                Correo.enviarCorreoHtml("Cambio de contraseña realizado", PlantillaCliente.getContenido(titulo, contenido), objetos.get(0)[1].toString());
                return "Cambio de contraseña realizado por favor verifique su correo electrónico.";
            }
            return "No se encuentra un usuario asociado al correo electrónico.";
        } catch (Exception e) {
        }
        return "No se pudo realizar la acción.";
    }
}
