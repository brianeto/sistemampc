/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.correo;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author Andres
 */
public class ConexionCorreo {
    
    protected final static String HOST = "smtp.gmail.com";
    protected final static String PORT = "587";
    protected final static String REMITENTE = "gaesmpc@gmail.com";
    protected final static String CLAVE = "sistemampc";

    public static String getPORT() {
        return PORT;
    }

    public static String getREMITENTE() {
        return REMITENTE;
    }

    
    protected static Session getSession() {
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", HOST);
        propiedades.put("mail.smtp.port", PORT);
        propiedades.put("mail.smtp.ssl.trust", HOST);
        Authenticator a = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REMITENTE, CLAVE);
            }
        };
        return Session.getInstance(propiedades, a);
    }
}
