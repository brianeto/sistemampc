/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectompc.controladores;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import proyectompc.core.Controlador;
import proyectompc.entidades.PreguntaSecreta;
import proyectompc.facades.PreguntaSecretaFacade;

/**
 *
 * @author Andres
 */
@Named
@RequestScoped
public class PreguntaSecretaControlador implements Serializable, Controlador<PreguntaSecreta>{

    private static final long serialVersionUID = 12L;
    @EJB
    private PreguntaSecretaFacade preguntasecretaFacade;
    private PreguntaSecreta preguntasecreta;

    public PreguntaSecreta getPreguntaSecreta(){
        return preguntasecreta;
    }
    
    public void setPreguntaSecreta(PreguntaSecreta preguntasecreta){
        this.preguntasecreta = preguntasecreta;
    }

    public PreguntaSecretaControlador(){
    }

    @PostConstruct
    public void iniciar(){
        preguntasecreta = new PreguntaSecreta();
    }

    @Override
    public PreguntaSecreta getEntidad(Integer llavePrimaria) {
        System.out.println("controlador : " + preguntasecretaFacade.find(llavePrimaria));
        return preguntasecretaFacade.find(llavePrimaria);
    }
    
    public List<PreguntaSecreta> PreguntaSecretas(){
        return preguntasecretaFacade.findAll();
    }
    
}
