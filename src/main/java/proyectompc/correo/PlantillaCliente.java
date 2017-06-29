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
public class PlantillaCliente {
    
    
    private static final String PLANTILLA = "<html><head><style>* {box-sizing:border-box;}body {border: 0;background:#f1f1f1;}main {min-height:500px;font-family:sans-serif;background:#f1f1f1;width:100%;display:flex;box-shadow:0px 0px 3px rgba(0,0,0.4);border-radius:10px;flex-direction:column;flex-wrap:wrap;margin:0 auto;max-width:800px;}header {background:#41b883;min-height:80px;padding:30px;color:white;font-size:25px;}section {padding:30px;color:#666;flex:1 1 auto;}a{color:green; font-weight:bold;}</style></head><body><main><header>%titulo</header><section style=\"background:#fdfdfd;box-shadow:0px -6px 3px rgba(0,0,0,.13);\">%contenido</section></main></body></html>";
    
    public static String getContenido(String titulo, String contenido){
        String contenidoTemp = PLANTILLA.replace("%titulo", titulo);
        return contenidoTemp.replace("%contenido", contenido);
    }
    
}
