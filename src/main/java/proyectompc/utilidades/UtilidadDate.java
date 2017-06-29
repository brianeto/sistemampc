/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.utilidades;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Andres
 */
public class UtilidadDate {

    public static int carcularEdad(Date fecha) {
        try {
            if (fecha != null) {
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(fecha);
                Calendar today = Calendar.getInstance();
                int diffYear = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
                int diffMonth = today.get(Calendar.MONTH) - calendar.get(Calendar.MONTH);
                int diffDay = today.get(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH);
                // Si está en ese año pero todavía no los ha cumplido
                if (diffMonth < 0 || (diffMonth == 0 && diffDay < 0)) {
                    diffYear = diffYear - 1;
                }
                return diffYear;
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static String caracteresFecha(Date fecha) {
        try {
            DateFormat formato = DateFormat.getDateInstance(DateFormat.FULL);
            return formato.format(fecha);
        } catch (Exception e) {
        }
        return null;
    }

    public static Date getFecha(int anio, int mes, int dia) {
        Calendar d = new GregorianCalendar(anio, mes, dia);
        return d.getTime();
    }
}