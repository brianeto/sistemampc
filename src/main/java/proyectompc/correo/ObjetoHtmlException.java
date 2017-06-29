/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.correo;
/**
 *
 * @author Andres
 */
public class ObjetoHtmlException extends Exception {

    public ObjetoHtmlException() {
        super("Error faltan argumentos - ObjetoHtml");
    }
    public ObjetoHtmlException(String name) {
        super("Error faltan argumentos - ObjetoHtml -" + name);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
