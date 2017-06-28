/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.ProveedorSuministro;

/**
 *
 * @author Andres
 */
@Stateless
public class ProveedorSuministroFacade extends AbstractFacade<ProveedorSuministro> {

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorSuministroFacade() {
        super(ProveedorSuministro.class);
    }
    
}
