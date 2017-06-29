/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.ContactoEmpresa;

/**
 *
 * @author Hector
 */
@FacesConverter(forClass = ContactoEmpresa.class)
public class ContactoEmpresaConvertidor extends Convertidor {

    public ContactoEmpresaConvertidor() {
        this.nombreControlador = "contactoEmpresaControlador";
    }
}
