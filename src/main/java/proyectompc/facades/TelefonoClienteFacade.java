/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.TelefonoCliente;

/**
 *
 * @author Andres
 */
@Stateless
public class TelefonoClienteFacade extends AbstractFacade<TelefonoCliente> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonoClienteFacade() {
        super(TelefonoCliente.class);
    }
    
}
