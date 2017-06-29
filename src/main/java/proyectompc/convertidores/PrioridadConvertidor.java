/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.Prioridad;

/**
 *
 * @author Hector
 */
@FacesConverter(forClass = Prioridad.class)
public class PrioridadConvertidor extends Convertidor {

    public PrioridadConvertidor() {
        this.nombreControlador = "prioridadControlador";
    }
}
