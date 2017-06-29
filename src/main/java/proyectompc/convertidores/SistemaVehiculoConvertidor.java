/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.SistemaVehiculo;

/**
 *
 * @author Hector
 */
@FacesConverter(forClass = SistemaVehiculo.class)
public class SistemaVehiculoConvertidor extends Convertidor {

    public SistemaVehiculoConvertidor() {
        this.nombreControlador = "sistemaVehiculoControlador";
    }
}
