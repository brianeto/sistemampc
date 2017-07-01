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

    public Usuario getUsuario(String usuario) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }

}
