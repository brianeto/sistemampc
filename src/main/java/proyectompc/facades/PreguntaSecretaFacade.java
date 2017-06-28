/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.PreguntaSecreta;

/**
 *
 * @author Andres
 */
@Stateless
public class PreguntaSecretaFacade extends AbstractFacade<PreguntaSecreta> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaSecretaFacade() {
        super(PreguntaSecreta.class);
    }
    
}
