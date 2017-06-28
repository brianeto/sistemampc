/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.TipoCombustible;

/**
 *
 * @author Andres
 */
@Stateless
public class TipoCombustibleFacade extends AbstractFacade<TipoCombustible> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCombustibleFacade() {
        super(TipoCombustible.class);
    }
    
}
