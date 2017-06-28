/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.cliente.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import proyectompc.entidades.Cliente;
/**
 *
 * @author Andres
 */
@Stateless
public class RegistrarCliente{

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrarCliente(){
    }
    
    public String registrarCliente(Cliente cliente){
        
        return new String();
    }
}