/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.correo;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Andres
 */
public class Correo {

    
    public static int enviarCorreoHtml(String asunto, String mensaje, String destinatario) {
        int resultado = 0;
        try {
            Session session = ConexionCorreo.getSession();
            Message msj = new MimeMessage(session);
            msj.setFrom(new InternetAddress(ConexionCorreo.REMITENTE));
            msj.setSubject(asunto);
            msj.setContent(mensaje, "text/html; charset=UTF-8");
            msj.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            Transport.send(msj);
            resultado = 1;
        } catch (AddressException ex) {
            System.out.println("La dirección del correo es inválida " + ex);
        } catch (MessagingException ex) {
            System.out.println("Se ha presentado un error al enviar el correo");
        }
        return resultado;
    }
    
}