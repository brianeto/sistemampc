/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.TelefonoCliente;

/**
 *
 * @author Hector
 */
@FacesConverter(forClass = TelefonoCliente.class)
public class TelefonoClienteConvertidor extends Convertidor {

    public TelefonoClienteConvertidor() {
        this.nombreControlador = "telefonoClienteControlador";
    }
}
