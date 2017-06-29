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
            Integer llave = Integer.valueOf(value);
            Controlador controlador = (Controlador) context.getELContext().getELResolver().getValue(context.getELContext(), null, nombreControlador);
            return controlador.getEntidad(llave);
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir a objeto");
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        try {
            if(value instanceof Entidad) {
                Entidad entidad = (Entidad) value;
                System.out.println(entidad.getId().toString());
                return entidad.getId().toString();
            }else {
                System.out.println("No es una instacia de Entidad");
                return null;
            }
        } catch (Exception e) {
            System.out.println("No se pudo convertir a String");
            return null;
        }
    }
    
}
