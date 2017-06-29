/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.cliente.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.Estado;
import proyectompc.entidades.Usuario;
/**
 *
 * @author Andres
 */
@Stateless
public class ActivarCliente{

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivarCliente(){
    }
    
    public boolean activarCliente(String hashUser) {
        try {
            Usuario usuarioTemp = (Usuario) getEntityManager().createNamedQuery("Usuario.findByHashUser").setParameter("hashUser", hashUser).getSingleResult();
            usuarioTemp.setHashUser(null);
            Estado estadoTemp = new Estado(1);
            usuarioTemp.setEstadoId(estadoTemp);
            getEntityManager().merge(usuarioTemp);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
}