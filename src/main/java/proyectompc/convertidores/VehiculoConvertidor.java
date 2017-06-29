/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.convertidores;

import javax.faces.convert.FacesConverter;
import proyectompc.core.Convertidor;
import proyectompc.entidades.Vehiculo;

/**
 *
 * @author Hector
 */
    @FacesConverter(forClass = Vehiculo.class)
    public class VehiculoConvertidor extends Convertidor {
        
        public VehiculoConvertidor(){
            this.nombreControlador = "vehiculoControlador";
        }
    }
