/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.empresa.negocio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import net.bootsfaces.utils.FacesMessages;
import proyectompc.entidades.ContactoEmpresa;
import proyectompc.entidades.Empresa;
import proyectompc.entidades.Estado;
import proyectompc.entidades.TipoUsuario;
import proyectompc.entidades.Usuario;
import proyectompc.utilidades.UtilidadString;
/**
 *
 * @author Andres
 */
@Stateless
public class RegistrarEmpresa{

    @PersistenceContext(unitName = "proyectompcPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrarEmpresa(){
    }
    
    public void registrarEmpresa(Usuario usuario, Empresa empresa, ContactoEmpresa contacto){
        try {
            if(getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario.getUsuario()).getResultList().size()> 0){
                FacesMessages.error("El nombre de usuario se encuentra en uso");
            }else {
                usuario.setEstadoId(new Estado(1));
                usuario.setClave(UtilidadString.cifrarStringSha(usuario.getClave()));
                usuario.setHashUser(null);
                usuario.setTipoUsuarioId(new TipoUsuario(3));
                empresa.setUsuarioId(usuario);
                getEntityManager().persist(usuario);
                Usuario u = getUsuario(usuario.getUsuario());
                empresa.setUsuarioId(u);
                empresa.setHashEmpresa(UtilidadString.generarClave(4)+u.getId());
                getEntityManager().persist(empresa);
                contacto.setEmpresaId(getEmpresa(empresa.getHashEmpresa()));
                getEntityManager().persist(contacto);
                FacesMessages.info("Registro realizado con éxito");
            }
        } catch (Exception e) {
        }
        FacesMessages.fatal("Ocurrio un error al intentar realizar la acción");
    }
    
    public Usuario getUsuario(String usuario) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }
    public Empresa getEmpresa(String hashEmpresa) {
        try {
            return (Empresa) getEntityManager().createNamedQuery("Empresa.findByHashEmpresa").setParameter("hashEmpresa", hashEmpresa).getSingleResult();
        } catch (Exception e) {
            return new Empresa();
        }
    }

    
}