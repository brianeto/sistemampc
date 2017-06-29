/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.MantenimientoDocumento;

/**
 *
 * @author Hector
 */
@FacesConverter(forClass = MantenimientoDocumento.class)
public class MantenimientoDocumentoConvertidor extends Convertidor {

    public MantenimientoDocumentoConvertidor() {
        this.nombreControlador = "mantenimientoDocumentoControlador";
    }
}
