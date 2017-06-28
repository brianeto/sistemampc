/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.TipoSuministro;

/**
 *
 * @author Andres
 */
@Stateless
public class TipoSuministroFacade extends AbstractFacade<TipoSuministro> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoSuministroFacade() {
        super(TipoSuministro.class);
    }
    
}
