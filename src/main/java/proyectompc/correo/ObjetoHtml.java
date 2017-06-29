/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.correo;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class ObjetoHtml {
    
    private String tagNombre;
    private String contenidoObjeto;
    private boolean esCerrado;
    private ArrayList<String[]> atributos;

    public String getTagNombre() {
        return tagNombre;
    }

    public void setTagNombre(String tagNombre) {
        this.tagNombre = tagNombre;
    }

    public String getContenidoObjeto() {
        return contenidoObjeto;
    }

    public void setContenidoObjeto(String contenidoObjeto) {
        this.contenidoObjeto = contenidoObjeto;
    }

    public ArrayList<String[]> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<String[]> atributos) {
        this.atributos = atributos;
    }

    public boolean isEsCerrado() {
        return esCerrado;
    }

    public void setEsCerrado(boolean esCerrado) {
        this.esCerrado = esCerrado;
    }
    
    public ObjetoHtml(){
        this.esCerrado = false;
        this.atributos = new ArrayList<>();
    }
    
    public static String contruirObjeto(ObjetoHtml objetoHtml) throws ObjetoHtmlException {
        if(objetoHtml.getTagNombre().isEmpty()){
            throw new ObjetoHtmlException("Sin tagName");
        }
        String[] name = {"name", objetoHtml.tagNombre.toLowerCase()};
        objetoHtml.atributos.add(name);
        String cadena = "<" + objetoHtml.getTagNombre() + " ";
        for(String[] attr : objetoHtml.atributos){
            cadena = cadena + attr[0] + "=" + "\""+attr[1]+"\" ";
        }
        if(objetoHtml.isEsCerrado()){
            cadena = cadena + ">" +objetoHtml.contenidoObjeto+ "</"+objetoHtml.getTagNombre() +">";
        }else {
            cadena = cadena + "/>";
        }
        return cadena;
    }
    
}