/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.core;

/**
 *
 * @author Andres
 * @param <T>
 */
public interface Controlador<T> {
    
    T getEntidad(Integer llavePrimaria);
    
}
