/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.core;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import proyectompc.entidades.Entidad;

/**
 *
 * @author Andres
 */
public class Convertidor implements Converter{

    protected String nombreControlador;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            Integer llavePrimaria = Integer.valueOf(value);
            Controlador controlador = (Controlador) context.getELContext().getELResolver().getValue(context.getELContext(), null, nombreControlador);
            return controlador.getEntidad(llavePrimaria);
        } catch (NumberFormatException e) {
            System.out.println("Convertidor (" +value+ ") :no se pudo convertir a entidad Convertidor " +e.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if(value instanceof Entidad) {
                Entidad entidad = (Entidad) value;
                return entidad.getId().toString();
            }else {
                System.out.println("Convertidor : no es una instacia de Entidad");
            }
        } catch (Exception e) {
            System.out.println("Convertidor : no se pudo convertir a string " + e.getMessage());
        }
        return new String();
    }
    
}
