/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.utilidades;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author Pablo Andres Ramirez
 */

public class UtilidadString {
    
    public static String generarClave(int longitudClave){
        String[] caracteres = {"A","B","C","D","E","F","G","H","Y","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        
        Random numero = new Random();
        String clave = "";
        int i;
        for(i=0; i<=longitudClave;i++){
            clave = clave + caracteres[(int)(numero.nextDouble()* caracteres.length - 1)] + (int)(numero.nextDouble()*9-1);
        }
        return clave;
    }
    
    public static String cifrarStringSha(String valor) {
        MessageDigest mDigest;
        try {
            mDigest = MessageDigest.getInstance("SHA-1");
            byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF)
                        | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            return null;
        }
    }
}