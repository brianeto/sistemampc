/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectompc.utilidades;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Andres
 */
@Named(value = "fechaControlador")
@RequestScoped
public class FechaControlador {

    private List<String> dias, anios;
    private List<Object[]> meses;

    public List<String> getDias() {
        return dias;
    }

    public void setDias(List<String> dias) {
        this.dias = dias;
    }

    public List<Object[]> getMeses() {
        return meses;
    }

    public void setMeses(List<Object[]> meses) {
        this.meses = meses;
    }

    public List<String> getAnios() {
        return anios;
    }

    public void setAnios(List<String> anios) {
        this.anios = anios;
    }

    public FechaControlador() {
    }

    @PostConstruct
    public void init() {
        anios = new ArrayList<>();
        meses = new ArrayList<>();
        dias = new ArrayList<>();
        this.inicializar();
    }

    public void inicializar() {
        Calendar c1 = Calendar.getInstance();
        int ano = c1.get(Calendar.YEAR) - 18;
        for (int i = 0; i < 40; i++) {
            anios.add(String.valueOf(ano--));
        }
        Object[] enero = {1, "Enero"};
        Object[] febrero = {2, "Enero"};
        Object[] marzo = {3, "Enero"};
        Object[] abril = {4, "Abril"};
        Object[] mayo = {5, "Mayo"};
        Object[] junio = {6, "Junio"};
        Object[] julio = {7, "Julio"};
        Object[] agosto = {8, "Agosto"};
        Object[] septiembre = {9, "Septiembre"};
        Object[] octubre = {10, "Octubre"};
        Object[] noviembre = {11, "Noviembre"};
        Object[] diciembre = {12, "diciembre"};
        meses.add(enero);
        meses.add(febrero);
        meses.add(marzo);
        meses.add(abril);
        meses.add(mayo);
        meses.add(junio);
        meses.add(julio);
        meses.add(agosto);
        meses.add(septiembre);
        meses.add(octubre);
        meses.add(noviembre);
        meses.add(diciembre);
        for (int j = 0; j < 31; j++) {
            if(j <=10) {
                dias.add(String.valueOf("0" + (j + 1)));
            }else {
                dias.add(String.valueOf(j + 1));
            }
        }
    }


    public String dia(Integer i) {
        String d = String.valueOf(i);
        if (d.length() == 1) {
            return "0" + d;
        }
        return d;
    }

    public List<String> modelo() {
        Calendar c1 = Calendar.getInstance();
        int ano = c1.get(Calendar.YEAR);
        List<String> modelos = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            modelos.add("" + ano--);
        }
        return modelos;
    }
    
    public Date mayor(){
        Calendar c1 = Calendar.getInstance();
        int ano = c1.get(Calendar.YEAR) - 18;
        c1.set(ano, 01, 01);
        Date d = c1.getTime();
        return d;
    }
}