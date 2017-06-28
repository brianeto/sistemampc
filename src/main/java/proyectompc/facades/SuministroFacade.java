/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.Suministro;

/**
 *
 * @author Andres
 */
@Stateless
public class SuministroFacade extends AbstractFacade<Suministro> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SuministroFacade() {
        super(Suministro.class);
    }
    
}
